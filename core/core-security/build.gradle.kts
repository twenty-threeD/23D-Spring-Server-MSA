plugins {
    id("buildsrc.convention.spring-boot-library")
}

dependencies {
    implementation(project(":core:core-common"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // JJWT
    implementation("io.jsonwebtoken:jjwt-api:0.13.0")
    implementation("io.jsonwebtoken:jjwt-impl:0.13.0")
    implementation("io.jsonwebtoken:jjwt-jackson:0.13.0")
}