package com.fatemehmsp.buildsrc

object NetworkDependencies {
    object Versions {
        const val retrofit = "2.6.0"
        const val okhttp = "3.12.12"
        const val moshi = "1.9.3"
    }

    val retrofit = Dependency("com.squareup.retrofit2:retrofit", Versions.retrofit)
    val okhttp = Dependency("com.squareup.okhttp3:okhttp", Versions.okhttp)
    val okhttpLogger = Dependency("com.squareup.okhttp3:logging-interceptor", Versions.okhttp)
    val converterMoshi = Dependency("com.squareup.retrofit2:converter-moshi", Versions.retrofit)
    val moshi = Dependency("com.squareup.moshi:moshi", Versions.moshi)
    val moshiCodegen = Dependency("com.squareup.moshi:moshi-kotlin-codegen", Versions.moshi)

}
