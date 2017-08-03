package me.msobhy.core.presentation

import android.os.Bundle
import android.support.annotation.CallSuper

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author mSobhy
 */
open class BasePresenter<ViewType> {

    private val compositeDisposable = CompositeDisposable()
    /**
     * @return the attached view, In case no view is attach a null will be returned.
     */
    protected var view: ViewType? = null
        private set

    @CallSuper
    open fun attachView(view: ViewType) {
        this.view = view
    }

    @CallSuper
    fun detachView() {
        view = null
        compositeDisposable.clear()
    }

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun restoreState(savedInstanceState: Bundle) {

    }

    fun saveState(outState: Bundle) {

    }
}