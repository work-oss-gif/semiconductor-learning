# Semiconductor Learning

A tiny Android app that teaches semiconductors in 6 groups and 39 short lessons. Every lesson ends with a quiz question, and the app remembers which lessons you have passed.

Groups: The Basics, Doping and the Diode, Transistors, Logic/Memory/Processors, How Chips Are Made, The Industry and the Future.

- Plain Java, no libraries. Lesson text is in `Content.java`, screens are in `MainActivity.java`.
- The APK is built by GitHub Actions on every push: open the run, scroll to **Artifacts**, download the zip and install `app-debug.apk`.
