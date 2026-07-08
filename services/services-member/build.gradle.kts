plugins {
    id("buildsrc.convention.spring-boot-application")
}

dependencies {

    // core-common
    implementation(project(":core:core-common"))

    // PostgreSQL
    runtimeOnly("org.postgresql:postgresql")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // phone
    implementation("com.github.L98293:phone:2.1.1")

    // secp256k1 algorithm
    implementation("org.bouncycastle:bcprov-jdk18on:1.80")

    // validation
    implementation ("org.springframework.boot:spring-boot-starter-validation")

    // dotenv
    developmentOnly("me.paulschwarz:springboot3-dotenv:5.1.0")

    // spring security
    //implementation("org.springframework.boot:spring-boot-starter-security")
}