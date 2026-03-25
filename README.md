# Basic Calculator Android App

A simple calculator app for Android built with Kotlin.

## Build via GitHub Actions (Free Cloud Build)

### Steps to get your APK:

1. **Create a GitHub repository:**
   ```bash
   cd BasicCalculator
   git init
   git add .
   git commit -m "Initial calculator app"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/calculator.git
   git push -u origin main
   ```

2. **Trigger the build:**
   - Go to your repo on GitHub
   - Click **Actions** tab
   - Click "Build APK" workflow
   - Click "Run workflow" → "Run workflow"

3. **Download the APK:**
   - Wait ~5-10 minutes for build to complete
   - Click on the build run
   - Scroll to "Artifacts" section
   - Click `calculator-apk` to download
   - Extract the zip → get `app-debug.apk`

4. **Install on your phone:**
   - Transfer APK to your Android device
   - Enable "Install from Unknown Sources" if needed
   - Tap the APK to install

## Features
- Addition, Subtraction, Multiplication, Division
- Clear button
- Decimal support
- Dark theme UI
- Division by zero error handling

## Tech Stack
- Kotlin
- AndroidX
- Material Design components
