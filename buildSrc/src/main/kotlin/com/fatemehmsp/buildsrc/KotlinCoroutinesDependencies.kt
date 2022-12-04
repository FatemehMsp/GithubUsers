package com.fatemehmsp.buildsrc

object KotlinCoroutinesDependencies {
    object Versions {
        const val coroutine = "1.3.7"
    }

    val coroutineAndroid =
        Dependency("org.jetbrains.kotlinx:kotlinx-coroutines-android", Versions.coroutine)
    val coroutineCore =
        Dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core", Versions.coroutine)
}