plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "itmo.swtest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    implementation(kotlin("script-runtime"))
//    testImplementation("org.mockito:mockito-core:4.1.0")
    testImplementation("org.mockito:mockito-inline:4.1.0")
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.8.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("AppKt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}