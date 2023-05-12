package com.example.loginudf.ui.state

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginudf.data.model.User


private const val MIN_SIZE_PASSWORD = 7

class LoginViewModel : ViewModel() {

    private var _emailString by mutableStateOf("")
    val emailString get() = _emailString
    fun changeEmailString(it: String) {
        _emailString = it
    }

    private var _passwordString by mutableStateOf("")
    val passwordString get() = _passwordString
    fun changePasswordString(it: String) {
        _passwordString = it
    }


    private var _loggedUser: User? by mutableStateOf(null)
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val logginError get() = _logginError


    fun loggin() {
        /* TODO: esta parte debería consultar un repository de la capa de datos en lugar de
             tener el nombre hardodeado, ya que normalmente el login se realizará contra un backend */
        if (_emailString == "pepe@pepe.com" && passwordString == "12345678") {
            _loggedUser = User(_emailString, _passwordString, "Pepe")
            _logginError = false
        } else _logginError = true
    }

    fun logOut() {
        _loggedUser = null
        _emailString = ""
        _passwordString = ""
    }


    fun validEmailAndPassword() = _emailString.isValidEmail() && _passwordString.isValidPassword()


    private fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()
    private fun String.isValidPassword() = this.length > MIN_SIZE_PASSWORD


}