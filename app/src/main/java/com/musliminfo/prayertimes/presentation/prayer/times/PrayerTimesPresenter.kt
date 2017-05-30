package com.musliminfo.prayertimes.presentation.prayer.times

import com.musliminfo.prayertimes.presentation.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Presenter to contain all the business logic for the prayer times screen
 */
@Singleton
class PrayerTimesPresenter @Inject constructor() : BasePresenter<PrayerTimesView>() {

    fun init() {
    }

    override fun attachView(view: PrayerTimesView) {
        super.attachView(view)
    }
}
