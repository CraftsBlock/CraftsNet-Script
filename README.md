# CraftsNet-Script
### A simple scripting language build module for craftsnet

![Latest Release on Maven](https://repo.craftsblock.de/api/badge/latest/releases/de/craftsblock/craftsnet/modules/script?color=40c14a&name=CraftsNet-Script&prefix=v)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/CraftsBlock/CraftsNet-Script)
![GitHub](https://img.shields.io/github/license/CraftsBlock/CraftsNet-Script)
![GitHub all releases](https://img.shields.io/github/downloads/CraftsBlock/CraftsNet-Script/total)
![GitHub issues](https://img.shields.io/github/issues-raw/CraftsBlock/CraftsNet-Script)

> [!NOTE]  
> CraftsNet-Script requires at least the version 3.0.7-SNAPSHOT of CraftsNet.
>
> It is also important to note that the internal compiler is currently under development and may change at any time!
> If you would like to contribute to the project, you are welcome to do so.

## Installation

### Maven
```xml
<repositories>
  ...
  <repository>
    <id>craftsblock-releases</id>
    <name>CraftsBlock Repositories</name>
    <url>https://repo.craftsblock.de/releases</url>
  </repository>
</repositories>
```
```xml
<dependencies>
  ...
  <dependency>
    <groupId>de.craftsblock.craftsnet.modules</groupId>
    <artifactId>script</artifactId>
    <version>X.X.X-SNAPSHOT</version>
  </dependency>
</dependencies>
```

### Gradle
```gradle
repositories {
  ...
  maven { url "https://repo.craftsblock.de/releases" }
  mavenCentral()
}
```
```gradle
dependencies {
  ...
  implementation "de.craftsblock.craftsnet.modules:script:X.X.X-SNAPSHOT"
}
```
