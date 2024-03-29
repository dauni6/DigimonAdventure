plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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
        jvmTarget = Project.javaVersion.toString()
    }

    kapt {
        generateStubs = true
    }
}

dependencies {
    // module
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))

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
    implementation(Dependencies.Network.retrofit_logging_interceptor)

    implementation(Dependencies.Serialization.kotlinx_serialization_json)

    // Paging3
    implementation(Dependencies.Paging3.paging3)

    // Logging
    implementation(Dependencies.Logging.timber)

}