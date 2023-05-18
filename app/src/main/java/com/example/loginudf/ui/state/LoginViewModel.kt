package com.example.loginudf.ui.state

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.loginudf.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


private const val MIN_SIZE_PASSWORD = 7

class LoginViewModel : ViewModel() {
    private val userRepository = UserRepository()

    private var _gameUiState = MutableStateFlow(GameUiState())
    val gameUiState = _gameUiState.asStateFlow()

    fun changeEmailString(it: String) {
        _gameUiState.update { currentState ->
            currentState.copy(emailString = it)
        }
    }

    fun changePasswordString(it: String) {
        _gameUiState.update { currentState ->
            currentState.copy(passwordString = it)
        }
    }


    fun loggin() {
        // _loggedUser = userRepository.authenticateUser(_emailString, _passwordString)
        //_logginError = _loggedUser?.let { false } ?: true

        _gameUiState.update { currentState ->
            val loggedUser = userRepository.authenticateUser(
                currentState.emailString,
                currentState.passwordString
            )
            currentState.copy(
                loggedUser = loggedUser,
                logginError = loggedUser?.let { false } ?: true
            )
        }
    }

    fun logOut() {
        _gameUiState.update { currentState ->
            currentState.copy(
                loggedUser = null,
                emailString = "",
                passwordString = "",
            )
        }
    }


    fun validEmailAndPassword() =
        _gameUiState.value.emailString.isValidEmail() &&
                _gameUiState.value.passwordString.isValidPassword()


    private fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()
    private fun String.isValidPassword() = this.length > MIN_SIZE_PASSWORD


}