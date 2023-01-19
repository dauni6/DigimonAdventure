plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Project.javaVersion
    targetCompatibility = Project.javaVersion
}

dependencies {
    // Kotlin
    implementation(Dependencies.Kotlin.stdlib)

    // Coroutine
    implementation(Dependencies.Coroutine.core)
    implementation(Dependencies.Coroutine.android)

    implementation(Dependencies.Javax.inject)
}