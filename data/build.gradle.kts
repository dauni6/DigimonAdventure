plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        minSdk = Project.MIN_SDK
        targetSdk = Project.TARGET_SDK
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = Project.javaVersion
        targetCompatibility = Project.javaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // module
    implementation(project(":domain"))

    implementation(Dependencies.Kotlin.core_ktx)

    // Coroutine
    implementation(Dependencies.Coroutine.core)

    // Javax
    implementation(Dependencies.Javax.inject)

    // DI
    implementation(Dependencies.DI.hilt_android)
    kapt(Dependencies.DI.hilt_compiler)

    // Room
    implementation(Dependencies.Room.room_ktx)
    implementation(Dependencies.Room.room_rumtime)
    kapt(Dependencies.Room.room_compiler)

    // Retrofit
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.retrofit_converter_moshi)

    // Moshi
    implementation(Dependencies.Network.moshi)
    kapt(Dependencies.Network.moshi_compiler)

    // Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext_junit)
    androidTestImplementation(Dependencies.Test.espresso_core)
}