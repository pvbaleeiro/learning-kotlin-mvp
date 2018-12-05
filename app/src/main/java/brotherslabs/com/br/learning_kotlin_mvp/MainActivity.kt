package brotherslabs.com.br.learning_kotlin_mvp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import brotherslabs.com.br.learning_kotlin_mvp.Presenter.ILoginPresenter
import brotherslabs.com.br.learning_kotlin_mvp.Presenter.LoginPresenter
import brotherslabs.com.br.learning_kotlin_mvp.View.ILoginView
import es.dmoral.toasty.Toasty

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), ILoginView {
    override fun onLoginResult(message: String) {
        Toasty.info(this, message, Toast.LENGTH_SHORT).show()
    }

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Init
        loginPresenter = LoginPresenter(this)

        // Event
        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
