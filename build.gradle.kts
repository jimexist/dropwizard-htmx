import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    application
    id("com.ncorti.ktfmt.gradle") version "0.15.1"
}

repositories {
    mavenCentral()
}

group = "me.jiayu"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

ktfmt {
    kotlinLangStyle()
}

application {
    mainClass.set("me.jiayu.dwapp.DwAppKt")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(platform("org.jdbi:jdbi3-bom:3.45.0"))
    implementation(platform("io.dropwizard:dropwizard-bom:4.0.4"))

    implementation("io.dropwizard:dropwizard-core")
    implementation("io.dropwizard:dropwizard-assets")
    implementation("io.dropwizard:dropwizard-jdbi3")
    implementation("io.dropwizard:dropwizard-migrations")
    implementation("io.dropwizard:dropwizard-views-mustache")
    implementation("io.dropwizard:dropwizard-configuration")
    implementation("org.jdbi:jdbi3-core")
    implementation("org.jdbi:jdbi3-sqlite")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")

    runtimeOnly("org.xerial:sqlite-jdbc:3.44.0.0")
}

