package com.example.loginudf.ui.elements

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

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
        label = { Text(text = "Email") },
        isError = logginError
    )
    OutlinedTextField(
        value = passwordString, onValueChange = changePasswordString,
        label = { Text(text = "Contraseña") },
        isError = logginError,
        visualTransformation = PasswordVisualTransformation(), // Para mostrar puntos
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
    Button(
        onClick = onLoggin,
        enabled = enableLoggin
    ) {
        Text(text = "Log In")
    }

}