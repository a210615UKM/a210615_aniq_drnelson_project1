# 🌍 Humanity — Donation & Volunteer Platform

<p align="center">
  <strong>An Android app connecting communities through donations, jobs, and volunteering.</strong><br>
  Built with Kotlin · Jetpack Compose · Material 3
</p>

---

## 📖 About This Project

**Humanity** is a modern Android application that empowers users to make a difference through:

- 💰 **Donating** to campaigns that fight poverty
- 💼 **Finding jobs** suited for those in need
- 🤝 **Volunteering** in local community events
- 👤 **Managing profiles** with personalized experiences

The app uses **Jetpack Compose** for a fully declarative UI — no XML layouts needed. Navigation between screens is handled by **Jetpack Navigation Compose**.

---

## ✅ Requirements

| Tool | Version |
|------|---------|
| [Android Studio](https://developer.android.com/studio) | Ladybug 2024.2.1 or newer |
| Kotlin | 1.9+ (bundled with Android Studio) |
| JDK | 11+ (bundled with Android Studio) |
| Android SDK | API 24 minimum · API 36 target |
| Git | Any recent version |

> 💡 **Note:** Android Studio includes the JDK and Kotlin compiler — no separate installation required.

---

## 🚀 Installation & Setup

### Step 1 — Clone or Download the Project

```bash
git clone https://github.com/your-username/Project1_Humanity.git
```

Or click **Code → Download ZIP** on GitHub, then extract the folder.

---

### Step 2 — Open in Android Studio

1. Launch **Android Studio**.
2. Click **File → Open** (or **"Open"** on the Welcome screen).
3. Navigate to the extracted/cloned folder and select the **root folder** named `Project1_Humanity`.
4. Click **OK**.

> ⚠️ **Important:** Always open the **root project folder** (the one containing `settings.gradle.kts`), NOT the `app` subfolder.

---

### Step 3 — Sync Gradle

When the project opens, Android Studio will begin a **Gradle Sync** automatically.

- Watch the **progress bar** at the bottom of the screen.
- If prompted to download missing SDK components, click **Install**.
- If sync doesn't start, manually trigger it: **File → Sync Project with Gradle Files**.

> 💡 **Tip:** First sync requires an internet connection and may take a few minutes.

---

### Step 4 — Run the App

#### Option A: Android Emulator

1. Go to **Tools → Device Manager**.
2. Click **Create Virtual Device**.
3. Pick a phone model (e.g., **Pixel 7**) → **Next**.
4. Select a system image with **API 30+** → **Next → Finish**.
5. Click the ▶️ button next to the emulator to start it.

#### Option B: Physical Device

1. On your phone: **Settings → About Phone → tap "Build Number" 7 times** to enable Developer Options.
2. Go to **Settings → Developer Options → enable USB Debugging**.
3. Connect via USB and accept the debugging prompt on your phone.

#### Run

1. Select your device from the **toolbar dropdown**.
2. Click the green **▶️ Run** button (or press `Shift + F10`).
3. The app will build and launch automatically.

---

## 🖥️ Recommended: Switch to "Android" View

This is the **most important step** for navigating the project easily.

### What is the Project Tool Window View Selector?

When you open a project, the left panel shows your files. At the **very top of that panel**, there's a small **dropdown menu** — this is the **view selector**.

### How to Switch

1. Look at the **top-left corner** of the Project Tool Window (the file tree panel).
2. Find the dropdown that says **"Project"** (this is the default).
3. **Click it** and select **"Android"** from the list.

### Why Use "Android" View?

| Feature | Project View | Android View ✅ |
|---------|-------------|----------------|
| Folder depth | Deep nested paths | Flat, logical groups |
| File organization | Raw filesystem | Grouped by purpose |
| Beginner-friendly | ❌ Confusing | ✅ Clear & simple |
| Shows Gradle Scripts | Hidden in tree | Dedicated section |
| Resource navigation | Buried in `res/` subfolders | Clean categories |

> 📌 **The "Android" view doesn't move or change your files.** It simply presents them in a way that makes Android development easier.

---

## 📂 Project Structure (Android View)

Once you switch to **Android** view, you'll see this organized layout:

```
📦 app
│
├── 📁 manifests
│    └── AndroidManifest.xml
│
├── 📁 java
│    └── com.example.a210615_aniq_drnelson_project1
│         │
│         ├── MainActivity.kt                ← App entry point
│         │
│         ├── 📁 components/                 ← Reusable UI pieces
│         │    ├── BottomNavigationBar.kt
│         │    └── UsernameHeader.kt
│         │
│         ├── 📁 data/                       ← Data models
│         │    └── UserData.kt
│         │
│         ├── 📁 navigation/                 ← Screen routing
│         │    ├── AppScreen.kt              (screen name definitions)
│         │    └── NavGraph.kt               (navigation logic)
│         │
│         ├── 📁 screens/                    ← All app screens
│         │    ├── 📁 auth/
│         │    │    ├── LoginScreen.kt
│         │    │    ├── SignUpScreen.kt
│         │    │    └── CustomTextField.kt
│         │    │
│         │    ├── 📁 main/
│         │    │    ├── MainScreen.kt
│         │    │    ├── HumanityHomeUI.kt
│         │    │    ├── DonateScreen.kt
│         │    │    ├── JobsScreen.kt
│         │    │    ├── VolunteerScreen.kt
│         │    │    ├── ProfileScreen.kt
│         │    │    └── WelcomeScreen.kt
│         │    │
│         │    ├── 📁 donation/
│         │    │    ├── DonationFormScreen.kt
│         │    │    ├── SummaryScreen.kt
│         │    │    ├── BankLoginScreen.kt
│         │    │    ├── ApprovalScreen.kt
│         │    │    ├── CompleteScreen.kt
│         │    │    └── ThankYouScreen.kt
│         │    │
│         │    └── 📁 editprofile/
│         │         └── EditProfileScreen.kt
│         │
│         ├── 📁 ui/theme/                   ← Colors, typography, theme
│         └── 📁 viewmodel/                  ← App state management
│              └── AppViewModel.kt
│
├── 📁 res
│    ├── 📁 drawable/                        ← Icons & images
│    ├── 📁 drawable-nodpi/                  ← Full-size images
│    ├── 📁 mipmap/                          ← App launcher icons
│    ├── 📁 values/                          ← Colors, strings, themes
│    └── 📁 xml/                             ← Backup rules
│
📦 Gradle Scripts
├── build.gradle.kts (Project)
├── build.gradle.kts (Module: app)
├── settings.gradle.kts
└── libs.versions.toml                       ← Dependency version catalog
```

---

## 🎯 Where Development Happens

Almost all your coding takes place inside this path:

```
Project1_Humanity/app/src/main/java/com/example/a210615_aniq_drnelson_project1/
```

In the **Android view**, this appears simply as:

```
app → java → com.example.a210615_aniq_drnelson_project1
```

This is where you'll find and create all Kotlin files — screens, components, navigation, data models, and view models.

### Why This Folder?

| Reason | Explanation |
|--------|-------------|
| Package root | All Kotlin classes belong to this package namespace |
| Organized subfolders | Screens, components, data, navigation are logically separated |
| Single source of truth | Every screen, model, and function lives here |
| Android convention | Standard Android project structure for source code |
| Easy imports | All files share the same base package, making imports simple |

---

## 🏗️ Software Architecture & Design

### Architecture Pattern: MVVM (Model-View-ViewModel)

This project follows the **MVVM** architecture pattern, which separates concerns into three layers:

```mermaid
graph TB
    subgraph "🖥️ VIEW Layer"
        A[Composable Screens]
        B[UI Components]
    end

    subgraph "🧠 VIEWMODEL Layer"
        C[AppViewModel]
    end

    subgraph "📦 MODEL Layer"
        D[UserData]
        E[Donation]
    end

    A -->|"Reads state"| C
    A -->|"Calls functions"| C
    B -->|"Displays data from"| C
    C -->|"Holds & manages"| D
    C -->|"Holds & manages"| E
```

| Layer | Role | Files in This Project |
|-------|------|----------------------|
| **View** | Displays UI, handles user interaction | All files in `screens/` and `components/` |
| **ViewModel** | Holds app state, business logic | `viewmodel/AppViewModel.kt` |
| **Model** | Data structures | `data/UserData.kt`, `data/Donation` |

### Why MVVM?

- **Separation of concerns** — UI code doesn't mix with logic
- **Survivable** — ViewModel survives screen rotations
- **Testable** — Logic can be tested without UI
- **Reactive** — UI automatically updates when data changes

---

## 🔗 How Everything Connects Together

### App Architecture Diagram

```mermaid
graph LR
    subgraph "Android System"
        OS[Android OS]
    end

    subgraph "App Entry"
        MA[MainActivity.kt]
    end

    subgraph "Navigation"
        NG[NavGraph.kt]
        AS[AppScreen.kt]
    end

    subgraph "State Management"
        VM[AppViewModel]
        UD[UserData]
    end

    subgraph "UI Screens"
        S1[Auth Screens]
        S2[Main Screens]
        S3[Donation Screens]
        S4[Profile Screens]
    end

    subgraph "Shared Components"
        BN[BottomNavigationBar]
        UH[UsernameHeader]
    end

    subgraph "Resources"
        DR[Drawables]
        TH[Theme/Colors]
        ST[Strings]
    end

    OS -->|"Launches"| MA
    MA -->|"Sets up"| NG
    NG -->|"Uses routes from"| AS
    NG -->|"Displays"| S1
    NG -->|"Displays"| S2
    NG -->|"Displays"| S3
    NG -->|"Displays"| S4
    S1 -->|"Reads/Writes"| VM
    S2 -->|"Reads/Writes"| VM
    S3 -->|"Reads/Writes"| VM
    S4 -->|"Reads/Writes"| VM
    VM -->|"Manages"| UD
    S2 -->|"Uses"| BN
    S2 -->|"Uses"| UH
    S1 -->|"Loads"| DR
    S2 -->|"Loads"| DR
    S1 -->|"Styled by"| TH
    S2 -->|"Styled by"| TH
```

### File Relationship Summary

| File | Depends On | Used By |
|------|-----------|---------|
| `MainActivity.kt` | NavGraph, AppTheme | Android System (entry point) |
| `NavGraph.kt` | AppScreen, All Screens, AppViewModel | MainActivity |
| `AppScreen.kt` | Nothing (enum definitions) | NavGraph, BottomNavigationBar |
| `AppViewModel.kt` | UserData, Donation | All Screens |
| `UserData.kt` | Nothing (data class) | AppViewModel |
| `BottomNavigationBar.kt` | AppScreen, NavController | MainScreen, DonateScreen, etc. |
| `LoginScreen.kt` | NavController, AppViewModel, CustomTextField | NavGraph |
| `DonationFormScreen.kt` | NavController, AppViewModel | NavGraph |

---

## 🔄 Understanding the Project Flow

### How the App Starts

```mermaid
sequenceDiagram
    participant OS as Android OS
    participant MA as MainActivity
    participant TH as AppTheme
    participant NC as NavController
    participant NG as NavGraph
    participant SU as SignUpScreen

    OS->>MA: onCreate() called
    MA->>TH: Apply Material 3 theme
    MA->>NC: Create NavController
    MA->>NG: Launch AppNavGraph
    NG->>SU: Show first screen (SignUp)
    Note over SU: User sees the Sign Up form
```

### How a User Action Flows Through the App

When a user taps a button (e.g., "Donate Now"):

```mermaid
sequenceDiagram
    participant U as User
    participant UI as DonateScreen
    participant NC as NavController
    participant NG as NavGraph
    participant DF as DonationFormScreen
    participant VM as AppViewModel
    participant D as UserData

    U->>UI: Taps "Donate Now" button
    UI->>NC: navController.navigate("DonationForm")
    NC->>NG: Resolves route
    NG->>DF: Displays DonationFormScreen
    U->>DF: Enters amount, taps Submit
    DF->>VM: viewModel.setDonationAmount("50")
    VM->>D: Updates userData.donationAmount
    DF->>NC: Navigate to Summary
    Note over NC: Summary reads amount from ViewModel
```

---

## 🧭 Screen Navigation Flow

### Complete Navigation Map

```mermaid
graph TD
    SU[📝 SignUp] -->|"Already have account?"| LI[🔐 Login]
    LI -->|"Don't have account?"| SU
    SU -->|"Sign Up success"| WE[👋 Welcome]
    LI -->|"Login success"| WE

    WE -->|"Get Started"| MN[🏠 Main/Home]

    MN -->|"Bottom Nav"| DN[💰 Donate]
    MN -->|"Bottom Nav"| JB[💼 Jobs]
    MN -->|"Bottom Nav"| VL[🤝 Volunteer]
    MN -->|"Bottom Nav"| PR[👤 Profile]

    DN -->|"Donate Now"| DF[📋 DonationForm]
    DF -->|"Next"| SM[📄 Summary]
    SM -->|"Proceed"| BL[🏦 BankLogin]
    BL -->|"Login"| AP[✅ Approval]
    AP -->|"Confirm"| CP[🎉 Complete]
    CP -->|"Continue"| TY[🙏 ThankYou]
    TY -->|"Back to Home"| MN

    PR -->|"Edit"| EP[✏️ EditProfile]
    EP -->|"Save"| PR

    style SU fill:#e3f2fd
    style LI fill:#e3f2fd
    style WE fill:#fff3e0
    style MN fill:#e8f5e9
    style DN fill:#fce4ec
    style JB fill:#f3e5f5
    style VL fill:#e0f7fa
    style PR fill:#fff8e1
```

### Bottom Navigation Structure

The app uses a **persistent bottom navigation bar** on main screens:

```mermaid
graph LR
    subgraph "Bottom Navigation Bar"
        H[🏠 Home]
        D[❤️ Donate]
        J[💼 Jobs]
        V[🤝 Volunteer]
        P[👤 Profile]
    end

    H --> MainScreen
    D --> DonateScreen
    J --> JobsScreen
    V --> VolunteerScreen
    P --> ProfileScreen
```

---

## 🔌 UI-to-Code Connection

### How UI Elements Map to Code

```mermaid
graph TD
    subgraph "What User Sees"
        BTN[Button: 'Donate Now']
        TXT[Text: 'RM 50.00']
        IMG[Image: donation_hero]
        NAV[Bottom Navigation]
    end

    subgraph "Kotlin Code"
        BF["Button(onClick = { navigate() })"]
        TF["Text(text = viewModel.userData.donationAmount)"]
        IF["Image(painterResource(R.drawable.donation_hero))"]
        NF["BottomNavigationBar(navController)"]
    end

    subgraph "Data Source"
        VM2[AppViewModel.userData]
        RES[res/drawable/]
        ROUTE[AppScreen enum]
    end

    BTN ---|"Defined by"| BF
    TXT ---|"Defined by"| TF
    IMG ---|"Defined by"| IF
    NAV ---|"Defined by"| NF

    TF ---|"Reads from"| VM2
    IF ---|"Loads from"| RES
    NF ---|"Routes from"| ROUTE
```

### Button Click → Action → Screen Change

Here's exactly what happens when a user taps a button:

```kotlin
// 1. User taps this button in DonateScreen.kt
Button(onClick = {
    navController.navigate(AppScreen.DonationForm.name)  // 2. Triggers navigation
}) {
    Text("Donate Now")  // 3. What the user sees
}

// 4. NavGraph.kt catches the route and shows DonationFormScreen
composable(AppScreen.DonationForm.name) {
    DonationFormScreen(navController, viewModel)  // 5. New screen appears
}
```

### How Data Flows from Input to Display

```kotlin
// Step 1: User types in DonationFormScreen.kt
TextField(value = amount, onValueChange = { amount = it })

// Step 2: User submits → ViewModel stores it
viewModel.setDonationAmount(amount)

// Step 3: SummaryScreen.kt reads it
Text("Amount: RM ${viewModel.userData.donationAmount}")
```

---

## 📊 Data & Function Connection Diagram

### ViewModel as Central Hub

```mermaid
graph TD
    subgraph "Screens that WRITE data"
        SU2[SignUpScreen] -->|"signUp()"| VM3[AppViewModel]
        LI2[LoginScreen] -->|"login()"| VM3
        DF2[DonationFormScreen] -->|"setDonationAmount()"| VM3
        AP2[ApprovalScreen] -->|"addDonation()"| VM3
        EP2[EditProfileScreen] -->|"updateProfile()"| VM3
    end

    subgraph "Screens that READ data"
        VM3 -->|"userData.username"| WE2[WelcomeScreen]
        VM3 -->|"userData.donationAmount"| SM2[SummaryScreen]
        VM3 -->|"userData.donationHistory"| PR2[ProfileScreen]
        VM3 -->|"userData.fullName"| HM[HomeUI]
        VM3 -->|"userData.*"| CP2[CompleteScreen]
    end

    subgraph "Data Storage"
        VM3 -->|"Holds"| UD2[UserData]
        UD2 -->|"Contains"| DON[List of Donations]
        UD2 -->|"Contains"| VOL[Volunteer History]
    end
```

### Key ViewModel Functions

| Function | What It Does | Called By |
|----------|-------------|-----------|
| `signUp()` | Stores new user registration data | SignUpScreen |
| `login()` | Validates username & password | LoginScreen |
| `setDonationAmount()` | Saves donation amount for flow | DonationFormScreen |
| `addDonation()` | Records completed donation with timestamp | ApprovalScreen |
| `updateProfile()` | Updates user profile fields | EditProfileScreen |
| `logout()` | Resets all user data | ProfileScreen |
| `clearDonationAmount()` | Clears temporary donation data | ThankYouScreen |

---

## 🔄 Android Lifecycle Basics

### What is the Android Lifecycle?

Every Android app goes through **lifecycle states**. Understanding this helps you know when your code runs.

```mermaid
stateDiagram-v2
    [*] --> Created: App launched
    Created --> Started: Activity visible
    Started --> Resumed: User can interact
    Resumed --> Paused: Another app overlaps
    Paused --> Stopped: App no longer visible
    Stopped --> Destroyed: System kills app
    Paused --> Resumed: User returns
    Stopped --> Started: User returns
    Destroyed --> [*]
```

### How This Project Handles Lifecycle

| Concern | How It's Handled |
|---------|-----------------|
| App start | `MainActivity.onCreate()` sets up Compose UI |
| Screen rotation | **ViewModel** survives rotation — data is preserved |
| User leaves app | Compose state is saved automatically |
| App killed by system | Data is lost (no persistent storage in this project) |

> 💡 **Key Insight:** The `AppViewModel` survives configuration changes (like rotation). That's why all screens read data from the ViewModel instead of storing it locally.

### Compose Lifecycle vs Activity Lifecycle

In Jetpack Compose, you don't manage lifecycle directly. Instead:

```kotlin
// Compose handles recomposition automatically
@Composable
fun ProfileScreen(viewModel: AppViewModel) {
    // This re-runs whenever viewModel.userData changes
    Text(text = viewModel.userData.username)
}
```

When `viewModel.userData` changes, Compose **automatically redraws** the affected UI. No manual `findViewById()` or `setText()` needed.

---

## 🗂️ How Android View Helps Development

### Android View vs Project View — Side by Side

#### ❌ Project View (Confusing for Beginners)

```
Project1_Humanity/
├── .gradle/
├── .idea/
├── app/
│   ├── build/
│   ├── src/
│   │   ├── androidTest/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── example/
│   │   │               └── a210615_aniq_drnelson_project1/
│   │   │                   └── ExampleInstrumentedTest.kt
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── a210615_aniq_drnelson_project1/
│   │   │   │               ├── MainActivity.kt    ← 6 levels deep!
│   │   │   │               └── ...
│   │   │   └── res/
│   │   └── test/
│   └── build.gradle.kts
├── gradle/
└── settings.gradle.kts
```

#### ✅ Android View (Clean & Logical)

```
app/
├── manifests/          ← 1 click away
├── java/              ← 1 click to your code
│   └── (your package) ← All your Kotlin files
├── res/               ← 1 click to resources
Gradle Scripts/        ← Always visible
```

### What Each Top-Level Folder Contains

| Folder | Purpose | What You'll Do Here |
|--------|---------|-------------------|
| **manifests** | App configuration, permissions, activity declarations | Rarely edit (only for permissions or new activities) |
| **java** | All Kotlin/Java source code | 🔥 **90% of your work happens here** |
| **res** | Images, icons, colors, strings, themes | Add images, change colors/strings |
| **Gradle Scripts** | Build configuration, dependencies | Add libraries, change SDK versions |

---

## 🔧 Development Workflow in Android Studio

### Daily Development Cycle

```mermaid
graph TD
    A[Open Android Studio] --> B[Switch to Android View]
    B --> C[Navigate to java/ folder]
    C --> D{What are you building?}

    D -->|"New Screen"| E[Create .kt file in screens/]
    D -->|"New Component"| F[Create .kt file in components/]
    D -->|"Add Data Model"| G[Create .kt file in data/]
    D -->|"Add Image"| H[Drop file in res/drawable/]

    E --> I[Register in NavGraph.kt]
    I --> J[Add route to AppScreen.kt]
    F --> K[Import in target screen]
    G --> L[Use in ViewModel]
    H --> M[Reference with R.drawable.name]

    J --> N[Run App ▶️]
    K --> N
    L --> N
    M --> N

    N --> O{Works?}
    O -->|"Yes ✅"| P[Commit changes]
    O -->|"No ❌"| Q[Check Logcat for errors]
    Q --> C
```

### Step-by-Step: Adding a New Screen

```mermaid
sequenceDiagram
    participant DEV as Developer
    participant AS as AppScreen.kt
    participant SC as screens/ folder
    participant NG as NavGraph.kt
    participant BN as BottomNav (optional)

    DEV->>AS: 1. Add new enum value
    Note over AS: enum class AppScreen { ..., NewScreen }

    DEV->>SC: 2. Create NewScreen.kt
    Note over SC: @Composable fun NewScreen(nav, vm) { }

    DEV->>NG: 3. Register composable route
    Note over NG: composable("NewScreen") { NewScreen(nav, vm) }

    DEV->>BN: 4. (Optional) Add to bottom nav
    Note over BN: Triple("New", icon, AppScreen.NewScreen.name)

    DEV->>DEV: 5. Run app and test ▶️
```

### How Files Communicate

```mermaid
graph LR
    subgraph "Screen File (e.g., DonateScreen.kt)"
        UI[UI Elements]
        CB[onClick Callbacks]
    end

    subgraph "Navigation"
        NC[NavController]
        NR[Route String]
    end

    subgraph "State"
        VM4[AppViewModel]
        ST2[userData State]
    end

    subgraph "Components"
        BN2[BottomNavigationBar]
        CT[CustomTextField]
    end

    CB -->|"navController.navigate()"| NC
    NC -->|"Resolves"| NR
    UI -->|"Reads"| ST2
    CB -->|"viewModel.function()"| VM4
    VM4 -->|"Updates"| ST2
    UI -->|"Includes"| BN2
    UI -->|"Includes"| CT
```

---

## 📦 Resource Management

### How Resources Connect to Code

```mermaid
graph TD
    subgraph "res/ Folder"
        DR2[drawable/donation_hero.jpg]
        DR3[drawable-nodpi/app_logo.png]
        STR[values/strings.xml]
        CLR[values/colors.xml]
        THM[values/themes.xml]
    end

    subgraph "Generated (Automatic)"
        R[R class]
    end

    subgraph "Kotlin Code"
        IMG2["painterResource(R.drawable.donation_hero)"]
        TXT2["stringResource(R.string.app_name)"]
        CLR2["colorResource(R.color.primary)"]
    end

    DR2 -->|"Generates"| R
    DR3 -->|"Generates"| R
    STR -->|"Generates"| R
    CLR -->|"Generates"| R
    R -->|"Accessed via"| IMG2
    R -->|"Accessed via"| TXT2
    R -->|"Accessed via"| CLR2
```

### Resource Types Explained

| Resource | Location | Access in Code | Example |
|----------|----------|---------------|---------|
| Images | `res/drawable/` | `R.drawable.filename` | `painterResource(R.drawable.donation_hero)` |
| HD Photos | `res/drawable-nodpi/` | `R.drawable.filename` | `painterResource(R.drawable.app_logo)` |
| App Icon | `res/mipmap/` | Set in AndroidManifest | Launcher icon |
| Strings | `res/values/strings.xml` | `R.string.name` | `stringResource(R.string.app_name)` |
| Colors | `res/values/colors.xml` | `R.color.name` | Used in themes |
| Themes | `res/values/themes.xml` | Applied in Manifest | App-wide styling |

### Rules for Resource Files

- ✅ Filenames must be **lowercase**
- ✅ Use **underscores** instead of spaces: `donation_hero.jpg`
- ❌ No special characters, hyphens, or capital letters
- ❌ No spaces in filenames
- 💡 After adding a resource, **rebuild** if `R.drawable.name` shows red

---

## 🏛️ Android Project Structure — How Android Studio Organizes Internally

### The Full Picture

```mermaid
graph TD
    subgraph "What You See (Android View)"
        AV[app]
        MF[manifests]
        JV[java]
        RS[res]
        GS[Gradle Scripts]
    end

    subgraph "What's Actually on Disk"
        ROOT[Project1_Humanity/]
        APP[app/]
        SRC[src/main/]
        JAVA[java/com/example/.../]
        RES2[res/]
        BUILD[build.gradle.kts]
        SETTINGS[settings.gradle.kts]
    end

    subgraph "Build System"
        GRADLE[Gradle]
        SDK[Android SDK]
        APK[APK Output]
    end

    AV -.->|"Maps to"| APP
    MF -.->|"Maps to"| SRC
    JV -.->|"Maps to"| JAVA
    RS -.->|"Maps to"| RES2
    GS -.->|"Maps to"| BUILD
    GS -.->|"Maps to"| SETTINGS

    GRADLE -->|"Compiles"| JAVA
    GRADLE -->|"Packages"| RES2
    GRADLE -->|"Uses"| SDK
    GRADLE -->|"Produces"| APK
```

### Build Process (What Happens When You Press ▶️)

```mermaid
graph LR
    A2[Kotlin Files] -->|"Compiled by"| B2[Kotlin Compiler]
    B2 --> C2[Bytecode]
    D2[Resources] -->|"Processed by"| E2[AAPT2]
    E2 --> F2[Compiled Resources]
    C2 --> G2[DEX Compiler]
    F2 --> G2
    G2 --> H2[APK File]
    H2 -->|"Installed on"| I2[Device/Emulator]
```

---

## 📚 Key Concepts for Beginners

### 🏠 MainActivity.kt — The Entry Point

Every Android app starts with an **Activity**. In this project, `MainActivity.kt` is the single activity that hosts the entire Compose UI. It sets up the theme and navigation controller.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}
```

> 💡 With Jetpack Compose, you typically have **one Activity** and many **Composable screens**.

---

### 🧭 Navigation — Moving Between Screens

Navigation is defined in `navigation/NavGraph.kt`. Each screen is registered as a **composable route**:

```kotlin
composable(AppScreen.Login.name) {
    LoginScreen(navController, viewModel)
}
```

To navigate from one screen to another:

```kotlin
navController.navigate(AppScreen.Donate.name)
```

Screen names are defined in `navigation/AppScreen.kt` as an enum.

---

### 🎨 Composable Screens — The UI

Each `.kt` file in the `screens/` folder is a **Composable function** that defines a full screen's UI. This project does **not** use XML layouts — everything is written in Kotlin using Jetpack Compose.

Example pattern:

```kotlin
@Composable
fun DonateScreen(navController: NavHostController, viewModel: AppViewModel) {
    // UI code using Column, Row, Text, Button, etc.
}
```

---

### 🖼️ Drawable Resources — Images & Icons

Images and icons live in the `res/drawable/` and `res/drawable-nodpi/` folders:

| Folder | Purpose |
|--------|---------|
| `drawable/` | Vector icons, XML drawables, small images |
| `drawable-nodpi/` | Full-resolution photos (no density scaling) |
| `mipmap/` | App launcher icon only |

To use an image in Compose:

```kotlin
Image(
    painter = painterResource(id = R.drawable.donation_hero),
    contentDescription = "Donation"
)
```

---

### 📝 Values Resources — Strings, Colors, Themes

| File | Purpose |
|------|---------|
| `res/values/strings.xml` | App name and text constants |
| `res/values/colors.xml` | Color definitions |
| `res/values/themes.xml` | App-wide theme configuration |

---

## ➕ Where to Add New Files

| What you're adding | Where to put it |
|-------------------|-----------------|
| New screen | `screens/` → create a subfolder or add to existing one |
| Reusable UI component | `components/` |
| New data class/model | `data/` |
| New navigation route | Add to `AppScreen.kt` enum + register in `NavGraph.kt` |
| New image/icon | `res/drawable/` or `res/drawable-nodpi/` |
| New ViewModel | `viewmodel/` |
| Theme changes | `ui/theme/` |

> 💡 **Tip:** After adding a new screen, always register it in `NavGraph.kt` so the app can navigate to it.

---

## 📱 App Flow

```
SignUp → Login → Welcome → Main (Home)
                                │
                    ┌───────────┼───────────┐
                    │           │           │
                 Donate       Jobs      Volunteer
                    │
            DonationForm
                    │
               Summary
                    │
             BankLogin
                    │
              Approval
                    │
              Complete
                    │
             ThankYou

         Profile → EditProfile
```

---

## 🛠️ Troubleshooting

| Problem | Solution |
|---------|----------|
| Gradle sync fails | Check internet. Try **File → Invalidate Caches → Restart**. |
| "SDK not found" | **File → Project Structure → SDK Location** → set correct path. |
| Emulator won't start | Enable VT-x / AMD-V in BIOS settings. |
| Unresolved references | Run **File → Sync Project with Gradle Files**. |
| `R.drawable` not found | Ensure image filenames are lowercase with no special characters. Rebuild project. |
| App crashes on launch | Open **Logcat** (bottom panel) and look for the red error stack trace. |
| Compose preview not showing | Click **"Build & Refresh"** in the preview panel. |
| Slow build times | Close unused apps. Increase Gradle heap: `org.gradle.jvmargs=-Xmx4096m` in `gradle.properties`. |
| ViewModel data lost | Ensure you're using shared ViewModel instance, not creating new ones per screen. |
| Navigation crash | Check that all routes in `AppScreen` are registered in `NavGraph.kt`. |
| "Unresolved reference: R" | Rebuild project: **Build → Rebuild Project**. |

---

## 🧰 Tech Stack

| Technology | Purpose |
|-----------|---------|
| Kotlin | Programming language |
| Jetpack Compose | Declarative UI framework |
| Material 3 | Design system & components |
| Navigation Compose | Screen-to-screen navigation |
| ViewModel | State management across screens |
| Google Fonts | Custom typography |
| Gradle Version Catalog | Dependency management |

---

## 💡 Tips for New Developers

1. **Always use Android view** — it saves time navigating files.
2. **Use Logcat** to debug crashes — filter by your app's package name.
3. **Compose Preview** lets you see UI without running the app — add `@Preview` annotation.
4. **Hot Reload** — use "Apply Changes" (⚡ icon) for faster iteration.
5. **Don't edit Gradle files** unless you know what you're doing — a bad edit can break the build.
6. **Name files clearly** — use `ScreenName + Screen.kt` pattern (e.g., `DonateScreen.kt`).
7. **Read ViewModel first** — understanding `AppViewModel.kt` helps you understand the whole app.
8. **Follow the navigation** — start at `NavGraph.kt` to see how screens connect.
9. **One screen = one file** — keep each screen in its own `.kt` file for clarity.
10. **Commit often** — save your progress with Git after each working feature.

---

## 📄 License

This project is developed for educational purposes as part of the **TTTM2213** course.

---

<p align="center">
  Made with using Jetpack Compose & Kotlin
</p>
