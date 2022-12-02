package com.fatemehmsp.buildsrc

object KotlinDependencies {

    object Versions{
        const val kotlin = "1.6.21"
    }

    val kotlin =
        Dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk7", Versions.kotlin)
    val kotlinPlugin =
        Dependency("org.jetbrains.kotlin:kotlin-gradle-plugin", Versions.kotlin)
}