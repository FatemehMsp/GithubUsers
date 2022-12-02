package com.fatemehmsp.buildsrc

object GlideDependencies {

    object Versions {
        const val glideVersion = "4.9.0"
    }

    val glide = Dependency("com.github.bumptech.glide:glide",Versions.glideVersion)
    val glideCompiler = Dependency("com.github.bumptech.glide:compiler",Versions.glideVersion)
}