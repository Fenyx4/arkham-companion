import 'package:flutter/material.dart';
import 'package:flutter_html/flutter_html.dart';
import 'expansion_model.dart';

final double cardHeight = 90.0;
final double cardWidth = 56.0;
final double aspectRatio = cardWidth / cardHeight;

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

          //double unitHeightValue = MediaQuery.of(context).size.height * 0.01;
          double unitWidthValue = MediaQuery.of(context).size.width * 0.01;

          return Padding(
            padding: const EdgeInsets.all(16.0),
            child: Align(
              alignment: Alignment.center,
              child: AspectRatio(
                aspectRatio: aspectRatio,
                child: LayoutBuilder(
                  builder: (context, constraints) {
                    final double calculatedHeight =
                        constraints.maxWidth * aspectRatio;
                    final double calculatedWidth = constraints.maxWidth;

                    return Card(
                      elevation: 6,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(16),
                      ),
                      clipBehavior: Clip
                          .antiAlias, // Ensures the background image is clipped to the card's border radius
                      child: Container(
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                                "assets/" + (neighborhood.cardPath ?? '')),
                            fit: BoxFit.fill,
                          ),
                        ),
                        child: Padding(
                          padding: EdgeInsets.fromLTRB(
                              calculatedWidth * 0.07,
                              calculatedHeight * 0.14,
                              calculatedWidth * 0.07,
                              calculatedHeight * 0.14),
                          child: ListView.builder(
                            itemCount: encounters.length,
                            itemBuilder: (context, encounterIndex) {
                              final encounter = encounters[encounterIndex];
                              final location = encounter.locationId != null
                                  ? neighborhood.locations.firstWhere(
                                      (loc) =>
                                          loc.locationID ==
                                          encounter.locationId,
                                      orElse: () => Location(
                                          locationID: 0,
                                          name: 'Unknown Location'))
                                  : null;
                              return Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Center(
                                    child: Text(
                                      '${location?.name}',
                                      textAlign: TextAlign.center,
                                      style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        fontFamily: "Caslon Antique",
                                        fontSize: calculatedHeight * 0.10,
                                        //backgroundColor: Colors.blue,
                                        color: Colors.black,
                                        // Ensures text is readable on image
                                        // shadows: [
                                        //   Shadow(
                                        //     blurRadius: 2,
                                        //     color: Colors.black,
                                        //     offset: Offset(1, 1),
                                        //   ),
                                        // ],
                                      ),
                                    ),
                                  ),
                                  //const SizedBox(height: 4),
                                  Html(
                                    data: encounter.text,
                                    style: {
                                      "body": Style(
                                        //backgroundColor: Colors.pink,
                                        fontFamily: "Tex Gyre Termes",
                                        fontSize:
                                            FontSize(calculatedHeight * 0.08),
                                        color: Colors.black,
                                        lineHeight: LineHeight(
                                            calculatedHeight * 0.007),
                                      ),
                                    },
                                  ),
                                  //const Divider(height: 0, color: Colors.white),
                                ],
                              );
                            },
                          ),
                        ),
                      ),
                    );
                  },
                ),
              ),
            ),
          );
        },
      ),
    );
  }
}
