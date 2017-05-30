package com.musliminfo.prayertimes.di

import com.musliminfo.prayertimes.App
import com.musliminfo.prayertimes.presentation.prayer.times.PrayerTimesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, RestModule::class, DataSourceModule::class, ServicesModule::class))
interface ApplicationComponent {
    fun inject(app: App)

    fun inject(prayerTimesActivity: PrayerTimesActivity)
}
