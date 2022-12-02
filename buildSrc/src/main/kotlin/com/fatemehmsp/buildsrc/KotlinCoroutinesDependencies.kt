package com.fatemehmsp.buildsrc

object KotlinCoroutinesDependencies {
    object Versions {
        const val coroutine = "1.6.4"
    }

    val coroutineAndroid =
        Dependency("org.jetbrains.kotlinx:kotlinx-coroutines-android", Versions.coroutine)
    val coroutineCore =
        Dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core", Versions.coroutine)
}