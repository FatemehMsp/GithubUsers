import com.fatemehmsp.buildsrc.*

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

android {
    compileSdkVersion(projectCompileSdkVersion)
    defaultConfig {
        minSdkVersion(projectMinSdkVersion)
        targetSdkVersion(projectTargetSdkVersion)
        versionCode = projectVersionCode
        versionName = projectVersionName

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
            isUseProguard = false
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

    buildFeatures{
        viewBinding = true
    }
}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to "*.jar")))

    implementation(project(":domain"))

    implementation(AndroidxDependencies.appCompat())
    implementation(AndroidxDependencies.constraintLayout())

    implementation(AndroidxDependencies.coreKtx())
    implementation(DesignDependencies.materialDesign())

    implementation(AndroidxDependencies.fragmentKtx())

    implementation(GlideDependencies.glide())
    kapt(GlideDependencies.glideCompiler())

    implementation(NavigationComponentDependencies.navigationFragmentKtx())
    implementation(NavigationComponentDependencies.navigationUiKtx())

    implementation(LifeCycleDependencies.lifeCycleViewModelKtx())
    implementation(LifeCycleDependencies.lifeCycleRuntimeKtx())
    implementation(LifeCycleDependencies.lifeCycleJava8())
    implementation(LifeCycleDependencies.lifeCycleLiveData())

    implementation(HiltDependencies.hilt())
    kapt(HiltDependencies.hiltCompiler())

    implementation(DesignDependencies.sdp())
}