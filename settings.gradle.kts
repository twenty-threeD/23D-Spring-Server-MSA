dependencyResolutionManagement {

    @Suppress("UnstableApiUsage")
    repositories {

        mavenCentral()
        maven("https://jitpack.io")
    }
}

// core
include("core:core-security")
include("core:core-common")

// services
include("services:services-auth")
include("services:services-member")

rootProject.name = "23D-Spring-Server-MSA"