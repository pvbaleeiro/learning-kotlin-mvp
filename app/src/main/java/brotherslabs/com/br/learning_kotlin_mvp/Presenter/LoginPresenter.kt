package brotherslabs.com.br.learning_kotlin_mvp.Presenter

import brotherslabs.com.br.learning_kotlin_mvp.View.ILoginView
import brotherslabs.com.br.learning_kotlin_mvp.model.User

class LoginPresenter (internal var iLoginView: ILoginView): ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val isLoginSuccess = user.isDataValid

        if (isLoginSuccess) {
            iLoginView.onLoginResult("Login success")
        } else {
            iLoginView.onLoginResult("Login failed")
        }
    }
}