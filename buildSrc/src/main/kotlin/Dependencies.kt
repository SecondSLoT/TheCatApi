object Dependencies {

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
        const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
        const val DAGGER = "com.google.dagger:dagger:${Versions.Google.DAGGER}"
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.Google.DAGGER}"
    }

    object Lifecycle {
        const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    }

    object Paging {
        const val RUNTIME = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    }

    object Retrofit {
        const val RETROFIT_LIB = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    }

    object Okhttp {
        const val LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object Navigation {
        const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    }

    object Glide {
        const val GLIDE_LIB = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
        const val COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}" // kapt
        const val KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    }

    object Coroutines {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.Unit.JUNIT}"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.Integration.JUNIT}"
            const val ESPRESSO_CORE =
                "androidx.test.espresso:espresso-core:${Versions.Test.Integration.ESPRESSO_CORE}"
            const val MOCKITO_KOTLIN =
                "org.mockito.kotlin:mockito-kotlin:${Versions.Test.Integration.MOCKITO}"
        }
    }
}
