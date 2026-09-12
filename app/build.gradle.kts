println("=== TRACE 4A: Configuration Phase - Evaluating :app Module ====")
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.android.example.gradlesandbox"
    compileSdk {
        version = release(37)
    }

    // 1. Define a dimension group
    flavorDimensions.add("pricing")

    // 2. Configure the actual flavors
    productFlavors {
        create("free") {
            dimension = "pricing"
            applicationIdSuffix = ".free"
            buildConfigField("Boolean", "SHOW_ADS", "true")
        }
    }
    
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.android.example.gradlesandbox"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false

            }

            manifestPlaceholders["appNameSuffix"] = ""
        }

        debug {
            applicationIdSuffix = ".debug"

            manifestPlaceholders["appNameSuffix"] = " (Debug)"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    implementation(project(":core:network")) // Added this module here to experiment how a module is treated as a differnt app when run on the emulator.
}