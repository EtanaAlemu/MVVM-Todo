plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id ("com.google.devtools.ksp") version "1.6.21-1.0.6"
    kotlin("kapt")
//    id("dagger.hilt.android.plugin")
    id ("com.google.dagger.hilt.android") version "2.48.1" apply false
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }



    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kapt { generateStubs = true }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    // App dependencies
    var appCompatVersion = "1.2.0"
    var constraintLayoutVersion = "2.0.4"
    var coroutinesVersion = "1.3.9"
    var dataStoreVersion = "1.0.0-alpha02"
    var espressoVersion = "3.3.0"
    var fragmentVersion = "1.3.0-beta01"
    var gradleVersion = "8.1.4"
    var hiltAndroidXVersion = "1.0.0-alpha03"
    var hiltVersion = "2.48.1"
    var junitVersion = "4.13.1"
    var kotlinVersion = "1.4.10"
    var ktxVersion = "1.3.2"
    var lifecycleVersion = "2.2.0"
    var materialVersion = "1.3.0-alpha03"
    var navigationVersion = "2.3.1"
    var roomVersion = "2.6.0"
    var testExtJunitVersion = "1.1.2"


    // Fragment
    implementation ("androidx.fragment:fragment-ktx:$fragmentVersion")


    // Lifecycle + ViewModel & LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
//    implementation "android.arch.lifecycle:common-java8:$lifecycleVersion"

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navigationVersion")

    // Room
    implementation ("androidx.room:room-runtime:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-android-compiler:$hiltVersion")
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidXVersion")
//    kapt ("androidx.hilt:hilt-compiler:$hiltAndroidXVersion")

    // DataStore
    implementation ("androidx.datastore:datastore-preferences:$dataStoreVersion")


}

kapt {
    javacOptions {
        option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
    }
}