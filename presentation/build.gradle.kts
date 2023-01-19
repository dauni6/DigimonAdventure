plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        applicationId = "com.dontsu.digimonadventure"
        minSdk = Project.MIN_SDK
        targetSdk = Project.TARGET_SDK
        versionCode = Project.versionCode
        versionName = Project.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Project.javaVersion
        targetCompatibility = Project.javaVersion
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

    kapt {
        generateStubs = true
    }
}

dependencies {
    // module
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Dependencies.Kotlin.core_ktx)
    implementation(Dependencies.Appcompat.appcompat)

    // AndroidX
    implementation(Dependencies.UI.activity_ktx)
    implementation(Dependencies.UI.fragment_ktx)

    // UI
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.recyclerview)
    implementation(Dependencies.UI.swiperefreshlayout)

    // DI
    implementation(Dependencies.DI.hilt_android)
    kapt(Dependencies.DI.hilt_compiler)

    // lifecycle
    implementation(Dependencies.Lifecycle.lifecycle_runtime_ktx)
    implementation(Dependencies.Lifecycle.lifecycle_viewmodel_ktx)

    // Glide
    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.glide_compiler)

    // Logging
    implementation(Dependencies.Logging.timber)

    // Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext_junit)
    androidTestImplementation(Dependencies.Test.espresso_core)

}