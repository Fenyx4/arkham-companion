import 'package:arkham_companion/checkbox_model.dart';
import 'package:flutter/material.dart';

import 'dart:convert';
import 'package:flutter/services.dart';

class ExpansionsPage extends StatefulWidget {
  const ExpansionsPage({super.key});

  @override
  State<ExpansionsPage> createState() => _ExpansionsPageState();
}

class _ExpansionsPageState extends State<ExpansionsPage> {
  @override
  initState() {
    super.initState();
    readJson();
  }

  List<Widget> buildCheckboxes(List<CheckboxModel> data) {
    return data.map((e) => buildSingleCheckbox(e)).toList();
  }

  Widget buildSingleCheckbox(CheckboxModel model) {
    TextStyle style = model.shouldToggle
        ? const TextStyle(color: Colors.black)
        : const TextStyle(color: Colors.grey);
    return ListTile(
      title: Text(
        model.title,
        style: style,
      ),
      leading: Checkbox(
        value: model.value,
        onChanged: (_) {
          //model.handler();
          setState(
            () {
              model.toggle();
            },
          );
        },
      ),
      onTap: () {
        setState(
          () {
            model.toggle();
          },
        );
      },
    );
  }

  // Fetch content from the json file
  Future<void> readJson() async {
    final String response =
        await rootBundle.loadString('assets/expansions.json');
    final data = await json.decode(response);
    setState(() {
      for (var element in data) {
        checkboxes.add(CheckboxModel(title: element["expName"], value: false));
      }
    });
  }

  List<CheckboxModel> checkboxes = [];
  //   CheckboxModel(title: 'Test 1', value: false),
  //   CheckboxModel(title: 'Test 2', value: false),
  //   CheckboxModel(title: 'Test 3', value: false),
  //   CheckboxModel(title: 'Test 4', value: false),
  // ];

  @override
  Widget build(BuildContext context) {
    TextStyle style =
        const TextStyle(fontSize: 28, fontWeight: FontWeight.bold);

    List<Widget> checkboxModels = buildCheckboxes(checkboxes);
    Column checkboxGroup = const Column(
      children: [],
    );

    for (var model in checkboxModels) {
      checkboxGroup.children.add(model);
    }

    return Column(
      // Column is also a layout widget. It takes a list of children and
      // arranges them vertically. By default, it sizes itself to fit its
      // children horizontally, and tries to be as tall as its parent.
      //
      // Invoke "debug painting" (press "p" in the console, choose the
      // "Toggle Debug Paint" action from the Flutter Inspector in Android
      // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
      // to see the wireframe for each widget.
      //
      // Column has various properties to control how it sizes itself and
      // how it positions its children. Here we use mainAxisAlignment to
      // center the children vertically; the main axis here is the vertical
      // axis because Columns are vertical (the cross axis would be
      // horizontal).
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        // ElevatedButton(
        //   onPressed: () {
        //     // Navigate to the second screen using a named route.
        //     Navigator.pushNamed(context, '/Neighborhoods');
        //     print('button pressed!');
        //   },
        //   child: Text('Next'),
        // ),
        Padding(
          padding: const EdgeInsets.all(.0),
          child: Center(child: Text('Expansion Selection', style: style)),
        ),
        Container(
            decoration: BoxDecoration(
              border: Border.all(),
              borderRadius: BorderRadius.circular(12),
            ),
            child: checkboxGroup),
      ],
    );
  }
}

class CallsPage extends StatelessWidget {
  const CallsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        appBar: AppBar(
          flexibleSpace: const Column(
            mainAxisAlignment: MainAxisAlignment.end,
            children: [
              TabBar(
                tabs: [
                  Tab(
                    text: 'Incoming',
                  ),
                  Tab(
                    text: 'Outgoing',
                  ),
                  Tab(
                    text: 'Missed',
                  ),
                ],
              )
            ],
          ),
        ),
        body: TabBarView(
          children: [
            IncomingPage(),
            OutgoingPage(),
            MissedPage(),
          ],
        ),
      ),
    );
  }
}

class IncomingPage extends StatefulWidget {
  const IncomingPage({super.key});

  @override
  _IncomingPageState createState() => _IncomingPageState();
}

class _IncomingPageState extends State<IncomingPage>
    with AutomaticKeepAliveClientMixin<IncomingPage> {
  int count = 10;

  void clear() {
    setState(() {
      count = 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.call_received, size: 350),
            // Text('Total incoming calls: $count',
            //     style: TextStyle(fontSize: 30)),
          ],
        ),
      ),
      // floatingActionButton: FloatingActionButton(
      //   onPressed: clear,
      //   child: Icon(Icons.clear_all),
      // ),
    );
  }

  @override
  bool get wantKeepAlive => true;
}

class OutgoingPage extends StatefulWidget {
  const OutgoingPage({super.key});

  @override
  _OutgoingPageState createState() => _OutgoingPageState();
}

class _OutgoingPageState extends State<OutgoingPage>
    with AutomaticKeepAliveClientMixin<OutgoingPage> {
  final items = List<String>.generate(10000, (i) => "Call $i");

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        //child: Icon(Icons.call_made_outlined, size: 350),
        child: ListView.builder(
          itemCount: items.length,
          itemBuilder: (context, index) {
            return ListTile(
              title: Text(items[index]),
            );
          },
        ),
      ),
    );
  }

  @override
  bool get wantKeepAlive => true;
}

class MissedPage extends StatelessWidget {
  const MissedPage({super.key});

  @override
  Widget build(BuildContext context) {
    return const Icon(Icons.call_missed_outgoing, size: 350);
  }
}
