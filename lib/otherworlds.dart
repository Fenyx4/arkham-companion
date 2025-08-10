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

          // Gather all colors from selected expansions
          final allColors =
              selectedExpansions.expand((exp) => exp.colors ?? []).toList();

          // Get the Color objects for this Otherworld's colorID list
          final colorPips = (ow.colorID ?? [])
              .map((id) => allColors.firstWhere(
                    (c) => c.colorID == id,
                    orElse: () => null,
                  ))
              .where((c) => c != null && c.colorPipOnPath != null)
              .toList();

          return LayoutBuilder(
            builder: (context, constraints) {
              // Use a fraction of the grid cell for the pip area
              final pipAreaSize =
                  constraints.maxWidth * 0.15; // 15% of cell width
              final pipSize = pipAreaSize / 2 - 2; // 2x2 grid, minus spacing

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
                  if (colorPips.isNotEmpty)
                    Positioned(
                      top: 8,
                      right: 8,
                      child: SizedBox(
                        width: pipAreaSize,
                        height: pipAreaSize,
                        child: GridView.builder(
                          physics: const NeverScrollableScrollPhysics(),
                          gridDelegate:
                              SliverGridDelegateWithFixedCrossAxisCount(
                            crossAxisCount: 2,
                            mainAxisSpacing: 2,
                            crossAxisSpacing: 2,
                          ),
                          itemCount: colorPips.length,
                          itemBuilder: (context, pipIndex) {
                            final c = colorPips[pipIndex];
                            return Image.asset(
                              'assets/${c!.colorPipOnPath}',
                              width: pipSize,
                              height: pipSize,
                              errorBuilder: (context, error, stackTrace) {
                                return SizedBox(
                                    width: pipSize, height: pipSize);
                              },
                            );
                          },
                        ),
                      ),
                    ),
                  // ...ElevatedButton code unchanged...
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
          );
        },
      ),
    );
  }
}
