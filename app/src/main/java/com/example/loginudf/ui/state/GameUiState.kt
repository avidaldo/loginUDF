package com.example.loginudf.ui.state

import com.example.loginudf.data.model.User

data class GameUiState(
    val emailString: String = "",
    val passwordString: String = "",
    val loggedUser: User? = null,
    val logginError: Boolean = false,
    )


