import com.fatemehmsp.buildsrc.*

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

android {
    compileSdkVersion(projectCompileSdkVersion)
    defaultConfig {
        applicationId = projectApplicationId
        minSdkVersion(projectMinSdkVersion)
        targetSdkVersion(projectTargetSdkVersion)
        versionCode = projectVersionCode
        versionName = projectVersionName

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {

        getByName("debug") {
            isMinifyEnabled = false
            isUseProguard = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("release") {
            isMinifyEnabled = true
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
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

    implementation(AndroidxDependencies.appCompat())
    implementation(AndroidxDependencies.constraintLayout())

    implementation(AndroidxDependencies.coreKtx())
    implementation(DesignDependencies.materialDesign())


    implementation(HiltDependencies.hilt())
    kapt(HiltDependencies.hiltCompiler())

    implementation(NetworkDependencies.retrofit())
    implementation(NetworkDependencies.okhttp())
    implementation(NetworkDependencies.okhttpLogger())
}