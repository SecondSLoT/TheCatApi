// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Config.Dependencies.GRADLE_PLUGIN)
        classpath(Config.Dependencies.KOTLIN_GRADLE_PLUGIN)

        // Safe Args
        classpath(Config.Dependencies.NAVIGATION_SAFEARGS_PLUGIN)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    }
}

//plugins {
//    id("io.gitlab.arturbosch.detekt") version "1.18.1"
//    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
//}

//subprojects {
//    apply plugin: "org.jlleitschuh.gradle.ktlint"
//    ktlint {
//        debug.set(false)
//    }
//}
//
//detekt {
//    toolVersion = "1.18.1"
//    config = files("config/detekt/detekt.yml")
//    buildUponDefaultConfig = true
//
//    source = files("app/src/main/java", "app/src/main/kotlin")
//
//    reports {
//        html {
//            enabled = true
//            destination = file("app/build/detekt/detekt.html")
//        }
//    }
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
