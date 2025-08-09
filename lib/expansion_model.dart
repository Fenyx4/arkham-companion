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

class Expansion {
  final int id;
  final String name;
  final String? iconPath;
  final String? cbIconPathOff;
  final String? cbIconPathOn;
  bool selected;
  final List<Neighborhood>? neighborhoods;

  Expansion({
    required this.id,
    required this.name,
    this.iconPath,
    this.cbIconPathOff,
    this.cbIconPathOn,
    this.selected = false,
    this.neighborhoods,
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
      };
}
