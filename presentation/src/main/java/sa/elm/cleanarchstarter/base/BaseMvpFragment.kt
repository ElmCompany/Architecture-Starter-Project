package sa.elm.cleanarchstarter.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View

@Suppress("UNCHECKED_CAST")
abstract class BaseMvpFragment<V, P : BasePresenter<V>> : BaseFragment() {
    lateinit var basePresenter: P

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateComponent()
        basePresenter = providePresenter()
        basePresenter.onBindView(this as V, savedInstanceState)
        basePresenter.onLoadData(arguments)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        basePresenter.onSaveInstanceState(outState)
        refreshPresenter()
    }

    @CallSuper
    protected fun refreshPresenter() {
        basePresenter.onLoadData(arguments)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        basePresenter.onUnBindView()
    }

    abstract fun onCreateComponent()

    abstract fun providePresenter(): P

}