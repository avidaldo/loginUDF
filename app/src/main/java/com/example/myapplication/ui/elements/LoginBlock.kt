package com.example.myapplication.ui.elements

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBlock(
    emailString: String,
    changeEmailString: (String) -> Unit,
    passwordString: String,
    changePasswordString: (String) -> Unit,
    logginError: Boolean,
    enableLoggin: Boolean,
    onLoggin: () -> Unit,
) {
    if (logginError)
        Text(
            text = "Email o contraseña inválidos",
            color = MaterialTheme.colorScheme.error
        )
    OutlinedTextField(
        value = emailString, onValueChange = changeEmailString,
        isError = logginError
    )
    OutlinedTextField(
        value = passwordString, onValueChange = changePasswordString,
        isError = logginError
    )
    Button(
        onClick = onLoggin,
        enabled = enableLoggin
    ) {
        Text(text = "Log In")
    }

}