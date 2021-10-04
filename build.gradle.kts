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

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.18.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

//subprojects {
//    plugins {
//       id("org.jlleitschuh.gradle.ktlint")
//    }
//
//    ktlint {
//        debug.set(false)
//    }
//}

//detekt {
//    buildUponDefaultConfig = true // preconfigure defaults
//    allRules = false // activate all available (even unstable) rules.
//    config =
//        files("$projectDir/config/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
////    baseline = file("$projectDir/config/detekt/baseline.xml") // a way of suppressing issues before introducing detekt
//    source = files("app/src/main/java", "app/src/main/kotlin")
//
//    reports {
//        html.enabled = true // observe findings in your browser with structure and code snippets
//    }
//
//}
//
//tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
//    // Target version of the generated JVM bytecode. It is used for type resolution.
//    jvmTarget = "1.8"
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
