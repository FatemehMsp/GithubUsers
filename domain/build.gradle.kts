import com.fatemehmsp.buildsrc.*

plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to "*.jar")))

    implementation(KotlinCoroutinesDependencies.coroutineCore())

    implementation(HiltDependencies.javaInject())
}