import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

repositories {
    mavenCentral()
}

group = "me.jiayu"
version = "1.0-SNAPSHOT"

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("me.jiayu.dwapp.DwAppKt")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(platform("org.jdbi:jdbi3-bom:3.35.0"))
    implementation(platform("io.dropwizard:dropwizard-bom:2.1.4"))

    implementation("io.dropwizard:dropwizard-core")
    implementation("io.dropwizard:dropwizard-jdbi3")
    implementation("io.dropwizard:dropwizard-views-mustache")
    implementation("io.dropwizard:dropwizard-configuration")
    implementation("org.jdbi:jdbi3-core")
    implementation("org.jdbi:jdbi3-sqlite")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.21")

    runtimeOnly("org.xerial:sqlite-jdbc:3.40.0.0")
}

