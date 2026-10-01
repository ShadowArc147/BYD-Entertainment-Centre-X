# BYD Entertainment Centre

A sleek, immersive Android media launcher designed for automotive rear-seat entertainment and headrest displays (such as BYD vehicle infotainment tablets).

`BYD Entertainment Centre` acts as a custom kiosk-style Home launcher (`android.intent.category.HOME`), providing rear-seat passengers with quick, single-tap access to popular streaming services in a clean, dark-themed landscape layout.

---

## 📸 Screenshots

| Main Launcher Screen | Streaming Service Integration |
| :---: | :---: |
| ![Main Screen](docs/screenshots/main_screen.png) | ![YouTube Launched](docs/screenshots/app_launcher_demo.png) |

*(Place screenshot images inside `docs/screenshots/` to display them on GitHub)*

---

## 🌟 Features

* **Instant Media Launching**: One-tap access to leading streaming platforms:
  * **Netflix** (`com.netflix.mediaclient`)
  * **Amazon Prime Video** (`com.amazon.avod.thirdpartyclient`)
  * **Disney+** (`com.disney.disneyplus`)
  * **YouTube** (`com.google.android.youtube`)
  * **Crunchyroll** (`com.crunchyroll.crunchyroid`)
* **Custom Home Launcher**: Operates as a replacement home launcher (`CATEGORY_HOME` & `CATEGORY_DEFAULT`) for kiosk environments.
* **Immersive Kiosk Feel**:
  * Auto-hides system bars and navigation bar on launch (`SYSTEM_UI_FLAG_IMMERSIVE_STICKY`).
  * Smooth fade-in entrance animation on startup.
* **Android 11+ Package Visibility Compliant**: Includes explicit `<queries>` declarations in `AndroidManifest.xml` to query and launch third-party streaming apps seamlessly on API 30+.
* **Automotive Display Ready**: Locked to landscape orientation for optimal display on vehicle tablets and headrests.

---

## 🛠️ Requirements & Tech Stack

* **Min SDK**: API 24 (Android 7.0)
* **Target / Compile SDK**: API 37
* **Language**: Kotlin
* **UI**: Android XML Layouts & Jetpack Compose
* **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)

---

## 📦 Generating the APK

You can build the APK using the Gradle Wrapper from the root project directory:

### 1. Build Debug APK
```bash
./gradlew assembleDebug
```
* **Output Path**: `app/build/outputs/apk/debug/app-debug.apk`

### 2. Build Release APK
```bash
./gradlew assembleRelease
```
* **Output Path**: `app/build/outputs/apk/release/app-release.apk`

---

## 📲 Installation Process

### Option A: Via ADB (Command Line)

1. Enable **Developer Options** and **USB Debugging** on your target device (e.g., Samsung Galaxy Tab, BYD Headrest Display, or Android Tablet).
2. Connect the device to your computer via USB or Wi-Fi ADB.
3. Verify the device is connected:
   ```bash
   adb devices
   ```
4. Install the APK:
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

### Option B: Via Android Studio

1. Open the project in Android Studio.
2. Select your connected target device or emulator from the device drop-down menu.
3. Click the green **Run** button (`Shift + F10`) or use the **Deploy** command.

---

## 🚀 Usage

1. Launch **BYD Entertainment Centre** from your app drawer.
2. *(Optional)* When pressing the Home button, select **BYD Entertainment Centre** and tap **Always** to set it as the default home screen launcher for rear-seat passengers.
3. Tap any streaming tile to open the app directly.
4. If a selected streaming service is not installed on the tablet, a toast message will appear: `"App not installed on this tablet."`
