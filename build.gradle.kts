import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
//    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("org.jetbrains.compose") version "1.4.0-alpha01-dev933"
    kotlin("plugin.serialization") version "1.8.0"
}
group = "ltd.boxin"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(project(":Common"))
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.netty:netty-all:5.0.0.Alpha2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0-RC")
}


allprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Company-management-system"
            packageVersion = "1.0.0"
        }
    }
}