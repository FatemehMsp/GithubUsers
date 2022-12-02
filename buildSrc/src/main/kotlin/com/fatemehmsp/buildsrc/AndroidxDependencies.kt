package com.fatemehmsp.buildsrc


object AndroidxDependencies {
    object Versions {
        const val appCompat = "1.5.1"
        const val constraintLayout = "2.1.4"
        const val coreKtx = "1.7.0"
        const val recyclerView = "1.1.0"
        const val annotation = "1.1.0"
        const val fragmentKtx = "1.3.0"
    }

    val appCompat = Dependency("androidx.appcompat:appcompat", Versions.appCompat)
    val coreKtx = Dependency("androidx.core:core-ktx", Versions.coreKtx)
    val recyclerView = Dependency("androidx.recyclerview:recyclerview", Versions.recyclerView)
    val annotation = Dependency("androidx.annotation:annotation", Versions.annotation)

    val fragmentKtx = Dependency("androidx.fragment:fragment-ktx", Versions.fragmentKtx)
    val fragment = Dependency("androidx.fragment:fragment", Versions.fragmentKtx)

    val constraintLayout = Dependency("androidx.constraintlayout:constraintlayout",Versions.constraintLayout)
}