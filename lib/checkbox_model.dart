import 'package:flutter/scheduler.dart';

class CheckboxModel {
  String title;
  bool value;
  bool shouldToggle = true;
  VoidCallback? onToggle;
  CheckboxModel({
    required this.title,
    required this.value,
    this.onToggle,
    this.shouldToggle = true,
  }) {
    onToggle = this.toggle;
  }
  void toggle() {
    if (shouldToggle) value = !value;
  }

  void enable(bool state) => shouldToggle = state;
  bool get isEnabled => shouldToggle;
  VoidCallback? handler() {
    if (shouldToggle) {
      return onToggle;
    } else {
      return null;
    }
  }
}
