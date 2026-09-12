println("🏁 INITIALIZATION PHASE: Gradle is reading settings.gradle.kts right now!!!!")
println("=== \uD83D\uDFE2 Trace 1: Initialization Phase - settings.gradle.kts is reading the module structure ===")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GradleSandbox"
include(":app")
include(":core:network")
include(":gradlesandboxdriver")

println("=== \uD83D\uDFE2 Trace 1: Initialization Phase - Found modules: :app, :core:network, :gradlesandboxdriver ===")
