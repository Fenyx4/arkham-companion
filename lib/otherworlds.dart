import 'dart:io';
import 'package:flutter/material.dart';
import 'expansion_model.dart';

class OtherworldsPage extends StatelessWidget {
  final List<Expansion> selectedExpansions;

  const OtherworldsPage({super.key, required this.selectedExpansions});

  @override
  Widget build(BuildContext context) {
    final otherWorlds = selectedExpansions
        .where((exp) => exp.selected)
        .expand((exp) => exp.otherWorldLocations ?? [])
        .toList();

    return Scaffold(
      appBar: AppBar(
        title: const Text('Otherworlds'),
      ),
      body: GridView.builder(
        padding: const EdgeInsets.all(8),
        gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2, // Two columns
          childAspectRatio: 2, // Adjust height/width ratio as needed
          crossAxisSpacing: 8,
          mainAxisSpacing: 8,
        ),
        itemCount: otherWorlds.length,
        itemBuilder: (BuildContext context, int index) {
          final ow = otherWorlds[index];
          const imagePath = 'assets/other/otherworld_loc_btn.png';
          return Stack(
            children: [
              Positioned.fill(
                child: Opacity(
                  opacity: 1.0,
                  child: Image.asset(
                    imagePath,
                    fit: BoxFit.cover,
                    errorBuilder: (context, error, stackTrace) {
                      return Image.asset(
                        'assets/other/otherworld_loc_btn.png',
                        fit: BoxFit.cover,
                      );
                    },
                  ),
                ),
              ),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.transparent,
                  shadowColor: Colors.transparent,
                  padding: const EdgeInsets.all(0),
                ),
                onPressed: () {
                  print("you clicked ${ow.name}");
                },
                child: Padding(
                  padding: const EdgeInsets.all(24.0),
                  child: Center(
                    child: Text(
                      ow.name,
                      textAlign: TextAlign.center,
                      style: const TextStyle(
                        fontFamily: "Caslon Antique",
                        fontSize: 20,
                      ),
                    ),
                  ),
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}
