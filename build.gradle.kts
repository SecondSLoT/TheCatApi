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

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
