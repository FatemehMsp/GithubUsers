import com.fatemehmsp.buildsrc.*

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(projectCompileSdkVersion)
    defaultConfig {
        minSdkVersion(projectMinSdkVersion)
        targetSdkVersion(projectTargetSdkVersion)
        versionCode = projectVersionCode
        versionName = projectVersionName
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to "*.jar")))

    implementation(project(":domain"))

    implementation(NetworkDependencies.retrofit())
    implementation(NetworkDependencies.okhttp())
    implementation(NetworkDependencies.okhttpLogger())
    implementation(NetworkDependencies.converterMoshi())
    implementation(NetworkDependencies.moshi())
    kapt(NetworkDependencies.moshiCodegen())

    implementation(AndroidxDependencies.coreKtx())

    implementation(HiltDependencies.hilt())
    kapt(HiltDependencies.hiltCompiler())

    implementation(KotlinCoroutinesDependencies.coroutineCore())
}
