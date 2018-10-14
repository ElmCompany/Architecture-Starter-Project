package sa.elm.cleanarchstarter.base

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V> {

    private val disposable = CompositeDisposable()
    protected var view: V? = null

    fun onBindView(view: V, savedInstanceState: Bundle?) {
        this.view = view
        onCreatePresenter(savedInstanceState)
    }

    fun onUnBindView() {
        disposable.clear()
        view = null
    }

    abstract fun onCreatePresenter(savedInstanceState: Bundle?)

    abstract fun onSaveInstanceState(outState: Bundle?)

    abstract fun onLoadData(arguments: Bundle? = null)
}