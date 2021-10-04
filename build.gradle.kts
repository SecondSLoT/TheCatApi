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

plugins {
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
    id("io.gitlab.arturbosch.detekt").version("1.18.1")
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    // point to your custom config defining rules to run, overwriting default behavior
    config = files("$projectDir/config/detekt/detekt.yml")
    source = files("app/src/main/java", "app/src/main/kotlin")

    reports {
        html.enabled = true // observe findings in your browser with structure and code snippets
        xml.enabled = false
        txt.enabled = true
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    // Target version of the generated JVM bytecode. It is used for type resolution.
    jvmTarget = JavaVersion.VERSION_1_8.toString()
}

ktlint {
    debug.set(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
