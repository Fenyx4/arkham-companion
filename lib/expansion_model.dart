class Neighborhood {
  final String name;
  final String? buttonPath;
  final String? cardPath;

  Neighborhood({
    required this.name,
    this.buttonPath,
    this.cardPath,
  });

  factory Neighborhood.fromJson(Map<String, dynamic> json) {
    return Neighborhood(
      name: json['name'] ?? '',
      buttonPath: json['buttonPath'],
      cardPath: json['cardPath'],
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

  Color({
    required this.colorButtonPath,
    this.colorPipOnPath,
    this.colorPipOffPath,
    required this.colorID,
    required this.name,
  });

  factory Color.fromJson(Map<String, dynamic> json) {
    return Color(
      colorButtonPath: json['colorButtonPath'] ?? '',
      colorPipOnPath: json['colorPipOnPath'],
      colorPipOffPath: json['colorPipOffPath'],
      colorID: json['colorID'],
      name: json['colorName'] ?? '',
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
