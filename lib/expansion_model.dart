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

class Expansion {
  final int id;
  final String name;
  final String? iconPath;
  final String? cbIconPathOff;
  final String? cbIconPathOn;
  bool selected;
  final List<Neighborhood>? neighborhoods;
  final List<Otherworld>? otherWorldLocations;

  Expansion({
    required this.id,
    required this.name,
    this.iconPath,
    this.cbIconPathOff,
    this.cbIconPathOn,
    this.selected = false,
    this.neighborhoods,
    this.otherWorldLocations,
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
      };
}
