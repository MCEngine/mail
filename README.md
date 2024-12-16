# Plugin for Bukkit/SpigotMC

This is a basic plugin for Bukkit/SpigotMC that provides email sending capabilities using the `MCEngineMailApi` library.

## Features
- Send emails asynchronously using Gmail, Hotmail, or similar SMTP services.
- Lightweight and easy to integrate into existing Minecraft plugins.
- Demonstrates proper usage of the `onEnable` and `onDisable` lifecycle methods in a Bukkit/SpigotMC plugin.

## Importing `MCEngineMailApi` Dependency

To use the `MCEngineMailApi` in your project, include it as a dependency in your build tool configuration. Below are the instructions for Gradle (Groovy and Kotlin DSL) and Maven.

### Gradle (Groovy DSL)
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.mcengine:mcengine-mail-api:1.0.0'
}
```

### Gradle (Kotlin DSL)
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.mcengine:mcengine-mail-api:1.0.0")
}
```

### Maven
```xml
<dependencies>
  <dependency>
    <groupId>io.github.mcengine</groupId>
    <artifactId>mcengine-mail-api</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

## Usage

### Setup
1. Include the `MCEngineMailApi` library in your plugin's dependencies.
2. Add the email configuration and logic in the `onEnable` method or based on your plugin's logic.

### Example Code

Below is a sample implementation of the plugin using `MCEngineMailApi` to send an email when the server starts.

```java
package io.github.mcengine; // Change to your package

import io.github.mcengine.api.MCEngineMailApi;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A simple Bukkit/Spigot plugin that sends an email when enabled.
 */
public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Configuration for email service
        String mailType = "gmail"; // "gmail", "hotmail"
        String username = "your-email@gmail.com";
        String password = "your-password-or-app-password";

        // Create an instance of MCEngineMailApi
        MCEngineMailApi mailApi = new MCEngineMailApi(mailType, username, password);

        // Send a test email
        String recipient = "recipient-email@example.com";
        String subject = "Server Started";
        String content = "The server has been enabled and is now running.";
        mailApi.sendEmail(recipient, subject, content);

        getLogger().info("Plugin enabled and test email sent.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled.");
    }
}
```

# `Member`

|Role|User|Email|
|-|-|-|
|owner|[`JetsadaWijit`](https://github.com/JetsadaWijit)|jetsadawijit@outlook.com|
