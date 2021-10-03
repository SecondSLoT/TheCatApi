plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.NAVIGATION_SAFEARGS)
}

android {
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        applicationId = "com.secondslot.thecatsapi"
        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK
        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = Config.TEST_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
        freeCompilerArgs = freeCompilerArgs + listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CORE)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT)
    implementation(Dependencies.Google.MATERIAL)

    // Lifecycle
    implementation(Dependencies.Lifecycle.LIVEDATA)
    implementation(Dependencies.Lifecycle.VIEWMODEL)
    implementation(Dependencies.Lifecycle.RUNTIME)

    // Paging
    implementation(Dependencies.Paging.RUNTIME)

    // Retrofit
    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.CONVERTER_GSON)

    // Okhttp
    implementation(Dependencies.Okhttp.LOGGING_INTERCEPTOR)

    // Gson
    implementation(Dependencies.Google.GSON)

    // Navigation
    implementation(Dependencies.Navigation.FRAGMENT)
    implementation(Dependencies.Navigation.UI)

    // Glide
    implementation(Dependencies.Glide.GLIDE)
    implementation(Dependencies.Glide.COMPILER)

    // Room
    implementation(Dependencies.Room.RUNTIME)
    kapt(Dependencies.Room.COMPILER)
    implementation(Dependencies.Room.KTX)

    // Coroutines
    implementation(Dependencies.Coroutines.CORE)
    implementation(Dependencies.Coroutines.ANDROID)

    // Dagger
    implementation(Dependencies.Google.DAGGER)
    kapt(Dependencies.Google.DAGGER_COMPILER)

    // Test
    testImplementation(Dependencies.Test.Unit.JUNIT)
    androidTestImplementation(Dependencies.Test.Integration.JUNIT)
    androidTestImplementation(Dependencies.Test.Integration.ESPRESSO_CORE)
}
