import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.20"
    application
    id("com.ncorti.ktfmt.gradle") version "0.14.0"
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

    implementation(platform("org.jdbi:jdbi3-bom:3.41.3"))
    implementation(platform("io.dropwizard:dropwizard-bom:4.0.3"))

    implementation("io.dropwizard:dropwizard-core")
    implementation("io.dropwizard:dropwizard-assets")
    implementation("io.dropwizard:dropwizard-jdbi3")
    implementation("io.dropwizard:dropwizard-migrations")
    implementation("io.dropwizard:dropwizard-views-mustache")
    implementation("io.dropwizard:dropwizard-configuration")
    implementation("org.jdbi:jdbi3-core")
    implementation("org.jdbi:jdbi3-sqlite")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")

    runtimeOnly("org.xerial:sqlite-jdbc:3.43.2.2")
}

