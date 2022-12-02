package com.fatemehmsp.buildsrc

object HiltDependencies {

    object Versions {
        const val hilt = "2.40"
    }

    val hilt = Dependency("com.google.dagger:hilt-android", Versions.hilt)
    val hiltCompiler = Dependency("com.google.dagger:hilt-android-compiler", Versions.hilt)
    val hiltPlugin = Dependency("com.google.dagger:hilt-android-gradle-plugin", Versions.hilt)
}