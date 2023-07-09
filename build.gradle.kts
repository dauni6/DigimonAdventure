// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    dependencies {
        classpath (Dependencies.GradlePlugin.kotlin)
        classpath (Dependencies.GradlePlugin.hilt)
    }
}

plugins {
    id ("com.android.application") version "7.4.2" apply false
    id ("com.android.library") version "7.4.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}