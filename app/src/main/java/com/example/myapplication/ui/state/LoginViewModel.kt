package com.example.myapplication.ui.state

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.User

class LoginViewModel : ViewModel() {


    private var _emailString by mutableStateOf("")
    val emailString get() = _emailString
    fun changeEmailString(it: String) { _emailString = it }

    private var _passwordString by mutableStateOf("")
    val passwordString get() = _passwordString
    fun changePasswordString(it: String) {_passwordString = it }


    private var _loggedUser : User? by mutableStateOf(null)
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val logginError get() = _logginError



    fun loggin() {
        if (_emailString=="pepe@pepe.com" && passwordString=="123") {
            _loggedUser = User(_emailString,_passwordString, "Pepe")
            _logginError=false
        }
        else
            _logginError=true
    }

    fun logOut() {
        _loggedUser = null
    }


    fun validEmailAndPassword() =
        Patterns.EMAIL_ADDRESS.matcher(_emailString).matches() &&
                _passwordString.length > 2



}