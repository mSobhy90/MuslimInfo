package com.musliminfo.prayertimes

import android.app.Application
import com.musliminfo.prayertimes.di.*

class App : Application() {

    companion object {
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dataSourceModule(DataSourceModule())
                .restModule(RestModule())
                .servicesModule(ServicesModule())
                .build()
        graph.inject(this)
    }
}