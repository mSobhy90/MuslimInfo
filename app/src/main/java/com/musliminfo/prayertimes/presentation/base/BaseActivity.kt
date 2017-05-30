package com.musliminfo.prayertimes.presentation.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.ButterKnife
import com.musliminfo.prayertimes.R
import javax.inject.Inject

abstract class BaseActivity<PresenterType : BasePresenter<ViewType>, ViewType> : AppCompatActivity() {

    @Inject
    lateinit var presenter: PresenterType
    protected var toolbar: Toolbar? = null

    abstract fun inject()

    @LayoutRes
    abstract fun layoutToInflate(): Int

    abstract val view: ViewType

    protected fun restoreState(savedInstanceState: Bundle) {}

    abstract val toolbarTitle: String

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(layoutToInflate())

        toolbar = findViewById(R.id.toolbar) as Toolbar
        if (toolbar != null) {
            toolbar!!.title = toolbarTitle
            setSupportActionBar(toolbar)
            if (supportActionBar != null && shouldShowUpButton()) {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            }
        }

        ButterKnife.bind(this)

        if (savedInstanceState != null) {
            restoreState(savedInstanceState)
        }
    }

    protected fun shouldShowUpButton(): Boolean {
        return true
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.attachView(view!!)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveState(outState)
    }

    protected fun saveState(outState: Bundle) {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
