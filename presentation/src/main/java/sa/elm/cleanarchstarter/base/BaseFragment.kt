package sa.elm.cleanarchstarter.base

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    var snackbar: Snackbar? = null

    protected fun showSnackBar(message: String, lenght: Int = Snackbar.LENGTH_LONG) {
        snackbar = view?.let { Snackbar.make(it, message, lenght) }
        snackbar?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        snackbar?.dismiss()
    }
}