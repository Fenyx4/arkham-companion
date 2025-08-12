import 'package:flutter/material.dart';
import 'package:flutter_html/flutter_html.dart';
import 'expansion_model.dart';

class NeighborhoodCardsPage extends StatelessWidget {
  final Neighborhood neighborhood;
  final List<Expansion> selectedExpansions;

  const NeighborhoodCardsPage(
      {super.key,
      required this.neighborhood,
      required this.selectedExpansions});

  @override
  Widget build(BuildContext context) {
    final cards = neighborhood.cards;

    return Scaffold(
      appBar: AppBar(
        title: Text('${neighborhood.name} Cards'),
      ),
      body: PageView.builder(
        itemCount: cards.length,
        itemBuilder: (context, cardIndex) {
          final card = cards[cardIndex];
          final encounters = card.encounters ?? [];

          return Padding(
            padding: const EdgeInsets.all(16.0),
            child: Card(
              elevation: 6,
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(16)),
              child: ListView.builder(
                padding: const EdgeInsets.all(16),
                itemCount: encounters.length,
                itemBuilder: (context, encounterIndex) {
                  final encounter = encounters[encounterIndex];
                  final location = encounter.locationId != null
                      ? neighborhood.locations.firstWhere(
                          (loc) => loc.locationID == encounter.locationId,
                          orElse: () =>
                              Location(locationID: 0, name: 'Unknown Location'))
                      : null;
                  return Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        '${location?.name}',
                        style: const TextStyle(
                          fontWeight: FontWeight.bold,
                          fontFamily: "Caslon Antique",
                          fontSize: 18,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Html(
                        data: encounter.text,
                        style: {
                          "body": Style(
                            fontSize: FontSize(18.0),
                            //fontFamily: "Caslon Antique"
                          ),
                        },
                        //style: const TextStyle(fontSize: 16),
                      ),
                      const Divider(height: 24),
                    ],
                  );
                },
              ),
            ),
          );
        },
      ),
    );
  }
}
