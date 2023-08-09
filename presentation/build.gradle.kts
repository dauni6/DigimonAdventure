plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dontsu.presentation"
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        minSdk = Project.MIN_SDK
        targetSdk = Project.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = Project.javaVersion
        targetCompatibility = Project.javaVersion
    }

    kotlinOptions {
        jvmTarget = Project.javaVersion.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))

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

    // Paging3
    implementation(Dependencies.Paging3.paging3)

    // Logging
    implementation(Dependencies.Logging.timber)

    // Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext_junit)
    androidTestImplementation(Dependencies.Test.espresso_core)
}