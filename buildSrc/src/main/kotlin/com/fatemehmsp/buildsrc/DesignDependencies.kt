package com.fatemehmsp.buildsrc

object DesignDependencies {

    object Versions {
        const val materialDesign = "1.2.1"
        const val ssp_sdp = "1.0.6"
    }

    val materialDesign = Dependency("com.google.android.material:material", Versions.materialDesign)
    val sdp = Dependency("com.intuit.sdp:sdp-android", Versions.ssp_sdp)
}