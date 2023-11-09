buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    `kotlin-dsl`
    kotlin("jvm") version embeddedKotlinVersion
    `java-gradle-plugin`
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlinx:kover-gradle-plugin:0.7.4")
}

gradlePlugin {
    plugins {
        create("customPlugin") {
            id = "custom-plugin"
            implementationClass = "CustomPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
