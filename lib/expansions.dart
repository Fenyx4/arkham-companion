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
          return ListTile(
            leading: Image.asset(
              'assets/${exp.selected ? exp.cbIconPathOn : exp.cbIconPathOff}',
              width: 32,
              height: 32,
            ),
            title: Text(exp.name),
            trailing: GestureDetector(
              onTap: () {
                setState(() {
                  exp.selected = !exp.selected;
                });
              },
              child: Image.asset(
                'assets/${exp.selected ? exp.cbIconPathOn : exp.cbIconPathOff}',
                width: 32,
                height: 32,
              ),
            ),
            onTap: () {
              setState(() {
                exp.selected = !exp.selected;
              });
            },
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
