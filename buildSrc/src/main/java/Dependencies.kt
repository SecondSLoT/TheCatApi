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
        const val RUNTIME = "androidx.paging:paging-runtime-ktx:3.0.1"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object Okhttp {
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    }

    object Navigation {
        const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:2.3.5"
        const val UI = "androidx.navigation:navigation-ui-ktx:2.3.5"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:4.12.0"
        const val COMPILER = "com.github.bumptech.glide:compiler:4.12.0"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:2.3.0"
        const val COMPILER = "androidx.room:room-compiler:2.3.0" // kapt
        const val KTX = "androidx.room:room-ktx:2.3.0"
    }

    object Coroutines {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:4.13.2"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:1.1.3"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
        }
    }
}
