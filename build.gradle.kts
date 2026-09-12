// Top-level build file where you can add configuration options common to all sub-projects/modules.
println("=== \uD83D\uDD35 TRACE 2: Configuration Phase - Root build.gradle.kts is executing ===")
plugins {
//    id("com.android.application")
//    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

tasks.register("helloDeveloper") {
    group = "my-first-tasks"
    description = "Greets the developer by their name."

    val nameProvider = providers.gradleProperty("devName"). orElse( "Developer")
    doLast {
        // Gradle logs the lifecycle phases automatically, so we just print our message safely
//        val name = project.findProperty("devName")?.toString() ?: "Developer"
        val name = nameProvider.get()
        println("🚀 Hello, $name! Your custom task read your name perfectly.")
    }
}

tasks.register("showAppVersion") {
    group = "my-first-tasks"
    description = "Reads and displays the current app version details."

    // Link the tasks together safely
    dependsOn("helloDeveloper")

    doLast {
        val appVersionName = "1.0.0"
        val currentYear = java.time.Year.now().value

        println("📦 App Version: $appVersionName")
        println("📅 Build Year: $currentYear")
    }
}