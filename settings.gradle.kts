pluginManagement {
    repositories {
        gradlePluginPortal()    // Plugins del Version Catalog y Gradle
        google()                // Plugin Android y Google Services
        mavenCentral()          // Otros plugins
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()       // Play Services, Firebase, Maps
        mavenCentral() // Retrofit, Maps Utils, Places API, etc.
    }
}

rootProject.name = "MiPrimeraAplicacion"
include(":app")
 