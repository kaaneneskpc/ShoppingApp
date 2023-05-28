buildscript {
    repositories {
        google()  // Google's Maven repository
        mavenCentral()  // Maven Central repository
    }
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.43")
    }
}
plugins {
    id("com.android.application") version "8.2.0-alpha04" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}