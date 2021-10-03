import org.gradle.api.JavaVersion

object Versions {

    object App {
        const val COMPILE_SDK = 31
        const val MIN_SDK = 21
        const val TARGET_SDK = 31
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"
    }

    object AndroidX {
        const val CORE = "1.6.0"
        const val APPCOMPAT = "1.3.1"
        const val CONSTRAINT_LAYOUT = "2.1.0"
        const val FRAGMENT = "1.3.6"
    }

    object Google {
        const val MATERIAL = "1.4.0"
        const val DAGGER = "2.35.1"
    }

    object Test {
        object Unit {
            const val JUNIT = "4.13.2"
        }

        object Integration {
            const val JUNIT = "1.1.3"
            const val ESPRESSO_CORE = "3.4.0"
        }
    }

    const val GRADLE = "7.0.2"
    const val KOTLIN = "1.5.31"
    const val NAVIGATION = "2.3.5"
    const val LIFECYCLE = "2.3.1"
    const val PAGING = "3.0.1"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.0"
    const val GSON = "2.8.6"
    const val GLIDE = "4.12.0"
    const val ROOM = "2.3.0"
    const val COROUTINES = "1.5.2"

    val JAVA = JavaVersion.VERSION_1_8
}
