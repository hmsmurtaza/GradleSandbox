import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.gradle.kotlin.dsl.repositories

plugins {
    `kotlin-dsl`
}

repositories{
    google()
    mavenCentral()
}

dependencies{
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id= "examplenetwork.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}
