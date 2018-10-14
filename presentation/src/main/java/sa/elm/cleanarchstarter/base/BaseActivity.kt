package sa.elm.cleanarchstarter.base

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import sa.elm.cleanarchstarter.R

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity : AppCompatActivity() {

    var snackbar: Snackbar? = null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun attachBaseContext(newBase: Context) {

    }

    protected fun showSnackBar(message: String, length: Int = Snackbar.LENGTH_LONG) {
        snackbar = findViewById<View>(android.R.id.content)?.let { Snackbar.make(it, message, length) }
        snackbar?.show()
    }

    protected fun showSnackBar(message: String, actionTest: String, actionListener: View.OnClickListener, length: Int = Snackbar.LENGTH_LONG) {
        snackbar = findViewById<View>(android.R.id.content)?.let { Snackbar.make(it, message, length) }
        snackbar?.setAction(actionTest, actionListener)
        snackbar?.show()
    }

    protected fun showDialog(title: String, message: String): MaterialDialog.Builder {
        return MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .cancelable(false)
                .canceledOnTouchOutside(false)
                .autoDismiss(false)
                .positiveText(R.string.ok)
    }
}