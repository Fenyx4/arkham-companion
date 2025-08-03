import 'package:flutter/material.dart';
import 'dart:convert';
import 'package:flutter/services.dart' show rootBundle;
import 'expansion_model.dart';

class ExpansionsPage extends StatefulWidget {
  const ExpansionsPage({super.key});

  @override
  State<ExpansionsPage> createState() => _ExpansionsPageState();
}

class _ExpansionsPageState extends State<ExpansionsPage> {
  List<Expansion> expansions = [];

  @override
  void initState() {
    super.initState();
    loadExpansions().then((loaded) {
      setState(() {
        expansions = loaded;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //appBar: AppBar(title: const Text('Expansion Selection')),
      body: ListView.builder(
        itemCount: expansions.length,
        itemBuilder: (context, index) {
          final exp = expansions[index];
          return CheckboxListTile(
            title: Text(exp.name),
            value: exp.selected,
            onChanged: (bool? value) {
              setState(() {
                exp.selected = value ?? false;
              });
            },
            secondary: exp.cbIconPathOff != null
                ? Image.asset('assets/${exp.cbIconPathOff!}',
                    width: 32, height: 32)
                : null,
          );
        },
      ),
    );
  }
}

Future<List<Expansion>> loadExpansions() async {
  final String response = await rootBundle.loadString('assets/expansions.json');
  final List<dynamic> data = json.decode(response);
  return data.map((e) => Expansion.fromJson(e)).toList();
}
