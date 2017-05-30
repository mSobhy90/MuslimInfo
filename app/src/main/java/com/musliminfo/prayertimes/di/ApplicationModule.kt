package com.musliminfo.prayertimes.di

import com.musliminfo.prayertimes.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule(private val application: App) {
    @Provides @Singleton fun provideApplication() = application
}