package brotherslabs.com.br.learning_kotlin_mvp.model

interface IUser {
    val email: String
    val password: String
    val isDataValid: Boolean
}