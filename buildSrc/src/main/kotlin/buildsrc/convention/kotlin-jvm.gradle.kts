package buildsrc.convention

plugins {

    kotlin("jvm")
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}