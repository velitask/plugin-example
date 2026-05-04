# Velitask Plugin Example

[Русский](README_ru.md)

A working example plugin for [Velitask](https://velitask.com) — clone, modify, build, drop into your Velitask plugins folder. A starting point for writing your own indicators, figures, and data sources using the [Velitask SDK](https://github.com/velitask/velitask-sdk).

## Quick start

```bash
git clone https://github.com/velitask/plugin-example
cd plugin-example
./gradlew jar
```

The resulting jar appears in `build/libs/example-indicator-1.0.0.jar`. Copy it into your Velitask plugins folder:

```
~/.velitask/plugins/example-indicator-1.0.0.jar
```

Restart Velitask — the example indicator becomes available in the indicators panel.

## What's inside

- `src/main/java/com/velitask/plugin/example/Plagin.java` — plugin entry point, registered in the manifest.
- `src/main/java/com/velitask/plugin/example/SpeedometerIndicator.java` — example indicator that renders a speedometer using SVG assets and a sensor input.
- `src/main/resources/strings/` — localization files (`strings.properties` + `strings_ru.properties`).
- `src/main/resources/svg/speedometer/` — SVG assets for the speedometer.

## How it depends on the SDK

```gradle
dependencies {
    compileOnly 'com.github.velitask:velitask-sdk:1.0.+'
}
```

The SDK is fetched from JitPack via the `https://jitpack.io` Maven repository. No extra setup needed.

## Make it your own

1. Rename the package: `com.velitask.plugin.example` → your own (e.g. `com.example.myplugin`).
2. Update the `Velitask-Plugin-Class` attribute in `build.gradle` to point to your renamed plugin class.
3. Replace `SpeedometerIndicator` with your own indicator(s) and assets.
4. Edit `strings/strings*.properties` for your localization keys.
5. `./gradlew jar` and drop the result into `~/.velitask/plugins/`.

## Localization check

```bash
./gradlew checkLocalization
```

Verifies that every `localized("key")` call in source code has a matching entry in `strings.properties` and `strings_ru.properties`.

## Documentation

- SDK API reference: https://javadoc.jitpack.io/com/github/velitask/velitask-sdk/latest/javadoc/
- SDK wiki & guides: https://github.com/velitask/velitask-sdk/wiki

## License

[MIT](LICENSE) — do anything you want with this template, no attribution required.

The Velitask SDK itself is licensed under [Apache License 2.0](https://github.com/velitask/velitask-sdk/blob/main/LICENSE).
