package com.fatemehmsp.buildsrc

object NavigationComponentDependencies {
    object Version {
        const val navigation = "2.3.0"
    }

    val navigationFragmentKtx =
        Dependency("androidx.navigation:navigation-fragment-ktx", Version.navigation)

    val navigationUiKtx =
        Dependency("androidx.navigation:navigation-ui-ktx", Version.navigation)

    val navigationTesting =
        Dependency("androidx.navigation:navigation-testing", Version.navigation)

}