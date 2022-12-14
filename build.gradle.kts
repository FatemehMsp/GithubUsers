import java.net.URI
import com.fatemehmsp.buildsrc.*


// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { this.url = URI("https://maven.google.com") }
        maven { this.url = URI("https://jitpack.io") }
    }
}