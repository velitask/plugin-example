# Velitask Plugin Example

[English](README.md)

Рабочий пример плагина для [Velitask](https://velitask.com) — клонируй, переделай, собери, положи в папку плагинов Velitask. Стартовая точка для написания собственных индикаторов, фигур и источников данных через [Velitask SDK](https://github.com/velitask/velitask-sdk).

## Быстрый старт

```bash
git clone https://github.com/velitask/plugin-example
cd plugin-example
./gradlew jar
```

Результат — `build/libs/example-indicator-1.0.0.jar`. Скопируйте в папку плагинов Velitask:

```
~/.velitask/plugins/example-indicator-1.0.0.jar
```

Перезапустите Velitask — пример-индикатор появится в панели индикаторов.

## Что внутри

- `src/main/java/com/velitask/plugin/example/Plagin.java` — точка входа плагина (зарегистрирована в манифесте). Объявляет UID, версию, локали и регистрирует индикатор.
- `src/main/java/com/velitask/plugin/example/SpeedometerIndicator.java` — пример индикатора, рисует спидометр из SVG-ассетов с привязкой к сенсору.
- `src/main/resources/strings/` — локализация (`strings.properties` + `strings_ru.properties`).
- `src/main/resources/svg/speedometer/` — SVG-ассеты спидометра.
- `src/main/resources/sql/setup/create.sql` — схема собственной БД плагина (таблица `import_log`). Минимальный smoke-тест API [`PluginDatabase`](https://javadoc.jitpack.io/com/github/velitask/velitask-sdk/latest/javadoc/com/velitask/sdk/db/PluginDatabase.html). При форке можно удалить (вместе с `Plagin.getDbVersion()`), если своя БД не нужна.

## Как зависит от SDK

```gradle
dependencies {
    compileOnly 'com.github.velitask:velitask-sdk:1.0.+'
}
```

SDK тянется из JitPack через Maven-репозиторий `https://jitpack.io`. Никакой дополнительной настройки.

## Сделать своим

1. Переименуйте пакет: `com.velitask.plugin.example` → ваш (например `com.example.myplugin`).
2. Поправьте атрибут `Velitask-Plugin-Class` в `build.gradle` — указать на ваш переименованный класс плагина.
3. Замените `SpeedometerIndicator` на свой индикатор (или несколько) с собственными ассетами.
4. Отредактируйте `strings/strings*.properties` под свои ключи локализации.
5. `./gradlew jar` и положите результат в `~/.velitask/plugins/`.

## Проверка локализации

```bash
./gradlew checkLocalization
```

Сверяет, что каждый вызов `localized("key")` в коде имеет соответствующую запись в `strings.properties` и `strings_ru.properties`.

## Документация

- Справочник API SDK: https://javadoc.jitpack.io/com/github/velitask/velitask-sdk/latest/javadoc/
- Wiki и гайды по SDK: https://github.com/velitask/velitask-sdk/wiki

## Лицензия

[MIT](LICENSE) — делайте что хотите с этим шаблоном, attribution не требуется.

Сам Velitask SDK распространяется под [Apache License 2.0](https://github.com/velitask/velitask-sdk/blob/main/LICENSE).
