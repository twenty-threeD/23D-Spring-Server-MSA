plugins {
    id("buildsrc.convention.spring-boot-application")
}

dependencies {

    // PostgreSQL
    runtimeOnly("org.postgresql:postgresql")

    // Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
}