package com.musliminfo.prayertimes.presentation.prayer.times

import com.musliminfo.prayertimes.App
import com.musliminfo.prayertimes.R
import me.msobhy.core.presentation.BaseActivity

class PrayerTimesActivity : BaseActivity<PrayerTimesPresenter, PrayerTimesView>(), PrayerTimesView {
    override fun inject() {
        App.graph.inject(this)
    }

    override fun shouldShowUpButton(): Boolean {
        return false
    }

    override fun layoutToInflate(): Int {
        return R.layout.activity_prayer_times
    }

    override val view: PrayerTimesView
        get() {
            return this
        }

    override val toolbarTitle: String
        get() = ""
}
