plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.foodprint.scanner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.foodprint.scanner"
        minSdk = 26 // Raised from 23 to 26 to support adaptive icons
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.7.1")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    // ML Kit OCR
    implementation("com.google.mlkit:text-recognition:16.0.0")
    // MPAndroidChart
    implementation("com.github.PhilJay:MPAndroidChart:3.1.0")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    // Testing
    testImplementation(libs.junit)
    testImplementation("org.mockito:mockito-core:5.2.0")
    testImplementation("app.cash.turbine:turbine:1.0.0")
    testImplementation("org.robolectric:robolectric:4.11.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    // JUnit5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    // Paparazzi for snapshot testing
    testImplementation("app.cash.paparazzi:paparazzi:1.3.1")
    // Hilt testing
    testImplementation("com.google.dagger:hilt-android-testing:2.51")
    kaptTest("com.google.dagger:hilt-android-compiler:2.51")
    // AndroidX test dependencies
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.test:core:1.5.0")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
