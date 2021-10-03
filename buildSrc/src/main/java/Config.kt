object Config {

    object Dependencies {
        const val GRADLE_PLUGIN = "com.android.tools.build:gradle${Versions.GRADLE}"
        const val KOTLIN_GRADLE_PLUGIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val NAVIGATION_SAFEARGS_PLUGIN =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
    }

    const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}
