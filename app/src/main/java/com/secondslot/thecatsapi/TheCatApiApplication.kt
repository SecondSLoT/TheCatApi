package com.secondslot.thecatsapi

import android.app.Application
import com.secondslot.thecatsapi.di.AppComponent
import com.secondslot.thecatsapi.di.AppModule
import com.secondslot.thecatsapi.di.DaggerAppComponent

class TheCatApiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        private lateinit var appComponent: AppComponent

        fun getComponent(): AppComponent {
            return appComponent
        }
    }
}
