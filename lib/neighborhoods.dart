import 'dart:io';
import 'package:flutter/material.dart';
import 'expansion_model.dart';

class NeighborhoodsPage extends StatelessWidget {
  final List<Expansion> selectedExpansions;

  const NeighborhoodsPage({super.key, required this.selectedExpansions});

  Future<String> _getButtonPath(String? buttonPath) async {
    if (buttonPath == null || buttonPath.isEmpty) {
      return 'assets/neighbourhood_overlay.png';
    }
    // Try to load the asset, fallback if not found
    try {
      // This will throw if asset doesn't exist
      await Future.delayed(Duration.zero); // Simulate async
      return 'assets/$buttonPath';
    } catch (_) {
      return 'assets/neighbourhood_overlay.png';
    }
  }

  @override
  Widget build(BuildContext context) {
    final neighborhoods = selectedExpansions
        .where((exp) => exp.selected)
        .expand((exp) => exp.neighborhoods ?? [])
        .toList();

    return Scaffold(
      appBar: AppBar(
        title: const Text('Neighborhoods'),
      ),
      body: GridView.builder(
        padding: const EdgeInsets.all(8),
        gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2, // Two columns
          childAspectRatio: 2, // Adjust height/width ratio as needed
          crossAxisSpacing: 8,
          mainAxisSpacing: 8,
        ),
        itemCount: neighborhoods.length,
        itemBuilder: (BuildContext context, int index) {
          final nei = neighborhoods[index];
          final imagePath =
              (nei.buttonPath != null && nei.buttonPath!.isNotEmpty)
                  ? 'assets/${nei.buttonPath}'
                  : 'assets/encounter/neighbourhood_overlay.png';
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
                        'assets/encounter/neighbourhood_overlay.png',
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
                  print("you clicked ${nei.name}");
                },
                child: Padding(
                  padding: const EdgeInsets.all(24.0),
                  child: Center(
                    child: Text(
                      nei.name,
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
