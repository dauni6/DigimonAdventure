plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
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
        jvmTarget = Project.javaVersion.toString()
    }
}

dependencies {
    // module
    implementation(project(":domain"))

    implementation(Dependencies.Serialization.kotlinx_serialization_json)

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
    implementation(Dependencies.Network.retrofit_serialization_converter)

    // Paging3
    implementation(Dependencies.Paging3.paging3)

    // Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext_junit)
    androidTestImplementation(Dependencies.Test.espresso_core)
}