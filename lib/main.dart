import 'package:arkham_companion/neighborhoods.dart';
import 'package:arkham_companion/expansions.dart';
import 'package:arkham_companion/otherworlds.dart';
import 'package:flutter/material.dart';
import 'expansion_model.dart';

void main() {
  runApp(const MyApp());
}

class ArkhamCompanion extends StatelessWidget {
  const ArkhamCompanion({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('First Route'),
      ),
      body: Center(
        child: ElevatedButton(
          child: const Text('Open route'),
          onPressed: () {
            // Navigate to second route when tapped.
            Navigator.pushNamed(context, '/Expansions');
          },
        ),
      ),
    );
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Arkham Companion',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      //home: const MyHomePage(title: 'Arkham Companion'),
      initialRoute: '/Expansions',
      routes: {
        // When navigating to the "/" route, build the FirstScreen widget.
        '/Expansions': (context) => const MyHomePage(title: 'Arkham Companion'),
        // When navigating to the "/second" route, build the SecondScreen widget.
        //'/Neighborhoods': (context) => const NeighborhoodsPage(),
      },
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
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

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget page;
    if (_selectedIndex == 0) {
      page = ExpansionsPage(
        expansions: expansions,
        onChanged: (updated) {
          setState(() {
            expansions = updated;
          });
        },
      );
    } else if (_selectedIndex == 1) {
      page = OtherworldsPage(selectedExpansions: expansions);
    } else {
      page = NeighborhoodsPage(selectedExpansions: expansions);
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(child: page),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.business),
            label: 'Otherworlds',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.location_city),
            label: 'Neighborhoods',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.amber[800],
        onTap: _onItemTapped,
      ),
    );
  }
}
