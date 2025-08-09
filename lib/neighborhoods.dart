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
      body: ListView.builder(
        padding: const EdgeInsets.all(8),
        itemCount: neighborhoods.length,
        itemBuilder: (BuildContext context, int index) {
          final nei = neighborhoods[index];
          final imagePath =
              (nei.buttonPath != null && nei.buttonPath!.isNotEmpty)
                  ? 'assets/${nei.buttonPath}'
                  : 'assets/encounter/neighbourhood_overlay.png';
          return GestureDetector(
              child: Container(
                  width: 120,
                  height: 80,
                  decoration: BoxDecoration(
                    color: Colors.black,
                    image: DecorationImage(
                        image: AssetImage(
                            "assets/encounter/neighbourhood_overlay.png"),
                        fit: BoxFit.fill),
                  ),
                  child: Center(child: Text("clickMe")) // button text
                  ),
              onTap: () {
                print("you clicked me");
              });
          // return Container(
          //   margin: const EdgeInsets.symmetric(vertical: 6),
          //   child: Stack(
          //     children: [
          //       Positioned.fill(
          //         child: Opacity(
          //           opacity: 0.3,
          //           child: Image.asset(
          //             imagePath,
          //             fit: BoxFit.cover,
          //             errorBuilder: (context, error, stackTrace) {
          //               return Image.asset(
          //                 'assets/encounter/neighbourhood_overlay.png',
          //                 fit: BoxFit.cover,
          //               );
          //             },
          //           ),
          //         ),
          //       ),
          //       ElevatedButton(
          //         style: ElevatedButton.styleFrom(
          //           minimumSize: const Size.fromHeight(60),
          //           backgroundColor: Colors.transparent,
          //           shadowColor: Colors.transparent,
          //           padding: const EdgeInsets.all(0),
          //         ),
          //         onPressed: () {
          //           // TODO: Define what happens when a neighborhood is pressed
          //         },
          //         child: Center(
          //           child: Text(
          //             nei.name,
          //             style: const TextStyle(
          //                 fontSize: 20, fontWeight: FontWeight.bold),
          //           ),
          //         ),
          //       ),
          //     ],
          //   ),
          // );
        },
      ),
    );
  }
}
