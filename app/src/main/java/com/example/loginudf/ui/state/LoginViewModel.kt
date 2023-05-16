package com.example.loginudf.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginudf.data.model.User
import com.example.loginudf.data.repository.UserRepository

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private var _loggedUser: User? by mutableStateOf(null)
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val logginError get() = _logginError


    fun loggin(emailString: String, passwordString: String) {
        _loggedUser = userRepository.authenticateUser(emailString, passwordString)
        _logginError = _loggedUser?.let { false } ?: true
    }

    fun logOut() {
        _loggedUser = null
    }

}