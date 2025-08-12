class Neighborhood {
  final String name;
  final String? buttonPath;
  final String? cardPath;
  final List<ArkhamCard> cards;
  final List<Location> locations;

  Neighborhood({
    required this.name,
    this.buttonPath,
    this.cardPath,
    this.cards = const [],
    this.locations = const [],
  });

  factory Neighborhood.fromJson(Map<String, dynamic> json) {
    return Neighborhood(
      name: json['name'] ?? '',
      buttonPath: json['buttonPath'],
      cardPath: json['cardPath'],
      cards: (json['cards'] as List?)
              ?.map((e) => ArkhamCard.fromJson(e))
              .toList() ??
          [],
      locations: (json['locations'] as List?)
              ?.map((e) => Location.fromJson(e))
              .toList() ??
          [],
    );
  }
}

class Location {
  final int locationID;
  final String name;

  Location({
    required this.locationID,
    required this.name,
  });

  factory Location.fromJson(Map<String, dynamic> json) {
    return Location(
      locationID: json['locationId'] ?? 0,
      name: json['name'] ?? 'Unknown Location',
    );
  }
}

class Encounter {
  final int locationId;
  final String text;

  Encounter({
    required this.locationId,
    required this.text,
  });

  factory Encounter.fromJson(Map<String, dynamic> json) {
    return Encounter(
      locationId: json['locationId'],
      text: json['text'] ?? '',
    );
  }
}

class ArkhamCard {
  final List<Encounter>? encounters;
  final List<int>? ColorIds;
  final List<int>? ExpansionIds;

  ArkhamCard({
    this.ColorIds,
    this.ExpansionIds,
    this.encounters,
  });

  factory ArkhamCard.fromJson(Map<String, dynamic> json) {
    return ArkhamCard(
      ColorIds: (json['ColorIds'] as List?)?.map((e) => e as int).toList(),
      ExpansionIds:
          (json['ExpansionIds'] as List?)?.map((e) => e as int).toList(),
      encounters: (json['encounters'] as List?)
          ?.map((e) => Encounter.fromJson(e))
          .toList(),
    );
  }
}

class Otherworld {
  //   "locationId": 499,
  // "name": "The Stars are Right",
  // "locButtonPath": "",
  // "sort": 0,
  // "colorID": []
  final String name;
  final int? locationId;
  final int? sort;
  final List<int>? colorID;

  Otherworld({
    required this.name,
    this.locationId,
    this.sort,
    this.colorID,
  });

  factory Otherworld.fromJson(Map<String, dynamic> json) {
    return Otherworld(
      name: json['name'] ?? '',
      locationId: json['locationId'],
      sort: json['sort'],
      colorID: (json['colorID'] as List?)?.map((e) => e as int).toList(),
    );
  }
}

class Color {
  //          "colorID": 1,
  // "name": "Yellow",
  // "colorButtonPath": "encounter/otherworld_color_btn_yellow.png",
  // "colorPipOnPath": "other/yellow_on.png",
  // "colorPipOffPath": "other/yellow_off.png"

  final String colorButtonPath;
  final String? colorPipOnPath;
  final String? colorPipOffPath;
  final int colorID;
  final String name;
  final List<ArkhamCard> cards;

  Color({
    required this.colorButtonPath,
    this.colorPipOnPath,
    this.colorPipOffPath,
    required this.colorID,
    required this.name,
    this.cards = const [],
  });

  factory Color.fromJson(Map<String, dynamic> json) {
    return Color(
      colorButtonPath: json['colorButtonPath'] ?? '',
      colorPipOnPath: json['colorPipOnPath'],
      colorPipOffPath: json['colorPipOffPath'],
      colorID: json['colorID'],
      name: json['colorName'] ?? '',
      cards: (json['cards'] as List?)
              ?.map((e) => ArkhamCard.fromJson(e))
              .toList() ??
          [],
    );
  }
}

class Expansion {
  final int id;
  final String name;
  final String? iconPath;
  final String? cbIconPathOff;
  final String? cbIconPathOn;
  bool selected;
  final List<Neighborhood>? neighborhoods;
  final List<Otherworld>? otherWorldLocations;
  final List<Color>? colors;

  Expansion({
    required this.id,
    required this.name,
    this.iconPath,
    this.cbIconPathOff,
    this.cbIconPathOn,
    this.selected = false,
    this.neighborhoods,
    this.otherWorldLocations,
    this.colors,
  });

  factory Expansion.fromJson(Map<String, dynamic> json) {
    return Expansion(
      id: json['id'],
      name: json['name'],
      iconPath: json['iconPath'],
      cbIconPathOff: json['cbIconPathOff'],
      cbIconPathOn: json['cbIconPathOn'],
      neighborhoods: (json['neighborhoods'] as List?)
          ?.map((n) => Neighborhood.fromJson(n))
          .toList(),
      otherWorldLocations: (json['otherWorldLocations'] as List?)
          ?.map((o) => Otherworld.fromJson(o))
          .toList(),
      colors: (json['colors'] as List?)?.map((c) => Color.fromJson(c)).toList(),
    );
  }

  Map<String, dynamic> toJson() => {
        'expID': id,
        'expName': name,
        'expIconPath': iconPath,
        'selected': selected,
        'neighborhoods': neighborhoods
            ?.map((n) => {
                  'name': n.name,
                  'buttonPath': n.buttonPath,
                  'cardPath': n.cardPath,
                })
            .toList(),
        'otherWorldLocations': otherWorldLocations
            ?.map((o) => {
                  'name': o.name,
                  'locationId': o.locationId,
                  'sort': o.sort,
                  'colorID': o.colorID,
                })
            .toList(),
        'colors': colors?.map((c) => {
              'colorButtonPath': c.colorButtonPath,
              'colorPipOnPath': c.colorPipOnPath,
              'colorPipOffPath': c.colorPipOffPath,
              'colorID': c.colorID,
              'colorName': c.name,
            })
      };
}
