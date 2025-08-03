class Expansion {
  final int id;
  final String name;
  final String? iconPath;
  final String? cbIconPathOff;
  final String? cbIconPathOn;
  bool selected;

  Expansion({
    required this.id,
    required this.name,
    this.iconPath,
    this.cbIconPathOff,
    this.cbIconPathOn,
    this.selected = false,
  });

  factory Expansion.fromJson(Map<String, dynamic> json) {
    return Expansion(
      id: json['expID'],
      name: json['expName'],
      iconPath: json['expIconPath'],
      cbIconPathOff: json['cbIconPathOff'],
      cbIconPathOn: json['cbIconPathOn'],
    );
  }

  Map<String, dynamic> toJson() => {
        'expID': id,
        'expName': name,
        'expIconPath': iconPath,
        'selected': selected,
      };
}
