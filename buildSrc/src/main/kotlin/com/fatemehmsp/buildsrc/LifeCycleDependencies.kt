package com.fatemehmsp.buildsrc

object LifeCycleDependencies {
    object Versions {
        const val lifeCycleVersion = "2.2.0"
    }

    val lifeCycleExtension =
        Dependency("androidx.lifecycle:lifecycle-extensions", Versions.lifeCycleVersion)
    val lifeCycleProcess =
        Dependency("androidx.lifecycle:lifecycle-process", Versions.lifeCycleVersion)
    val lifeCycleViewModelKtx =
        Dependency("androidx.lifecycle:lifecycle-viewmodel-ktx", Versions.lifeCycleVersion)
    val lifeCycleJava8 =
        Dependency("androidx.lifecycle:lifecycle-common-java8", Versions.lifeCycleVersion)
    val lifeCycleRuntimeKtx =
        Dependency("androidx.lifecycle:lifecycle-runtime-ktx", Versions.lifeCycleVersion)
    val lifeCycleCoreTesting = Dependency("androidx.arch.core:core-testing", "2.1.0")

    val lifeCycleLiveData =
        Dependency("androidx.lifecycle:lifecycle-livedata-ktx", Versions.lifeCycleVersion)

    val reactivestreams =
        Dependency("androidx.lifecycle:lifecycle-reactivestreams-ktx", Versions.lifeCycleVersion)

    val lifeCycleCompiler =
        Dependency("androidx.lifecycle:lifecycle-compiler", Versions.lifeCycleVersion)
}