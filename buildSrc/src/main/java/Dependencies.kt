object Dependencies {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    }

    object Appcompat {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    }

    object UI {
        const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"
        const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
        const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    }

    object GradlePlugin {
        //        const val android = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_serialization}"
    }

    object Lifecycle {
        const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    }

    object DI {
        const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object Room {
        const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
        const val room_rumtime =  "androidx.room:room-runtime:${Versions.room}"
        const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Network {
        // Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofit_serialization_converter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofit_serialization_converter}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Logging {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_core}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_android}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:${Versions.javax_inject}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
        const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    }

    object Serialization {
        const val kotlinx_serialization_json = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization_json}"
    }

}