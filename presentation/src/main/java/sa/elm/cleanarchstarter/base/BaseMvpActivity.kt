package sa.elm.cleanarchstarter.base

import android.os.Bundle
import android.support.annotation.CallSuper

@Suppress("UNCHECKED_CAST")
abstract class BaseMvpActivity<V, P : BasePresenter<V>> : BaseActivity() {

    lateinit var basePresenter: P

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateComponent()
        basePresenter = providePresenter()
        basePresenter.onBindView(this as V, savedInstanceState)
    }

    @CallSuper
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        refreshPresenter()
    }

    protected fun refreshPresenter() {
        basePresenter.onLoadData(intent?.extras)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        basePresenter.onSaveInstanceState(outState)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        basePresenter.onUnBindView()
    }

    abstract fun onCreateComponent()

    abstract fun providePresenter(): P
}