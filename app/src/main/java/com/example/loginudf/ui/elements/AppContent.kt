package com.example.loginudf.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginudf.R
import com.example.loginudf.ui.state.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {

    val vm: LoginViewModel = viewModel()

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = vm.loggedUser?.name ?: stringResource(R.string.login)
                )
            },
            actions = {
                vm.loggedUser?.let {
                    Button(onClick = { vm.logOut() }) {
                        Text(text = stringResource(R.string.log_out))
                    }
                }
            }
        )
    }) { paddingValues ->
        Column(
            Modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            vm.loggedUser?.let {
                Text(text = stringResource(R.string.acceso_correcto))
                // TODO: Contenido para usuarios loggeados
            } ?: LoginBlock(
                emailString = vm.emailString,
                changeEmailString = { vm.changeEmailString(it) },
                passwordString = vm.passwordString,
                changePasswordString = { vm.changePasswordString(it) },
                logginError = vm.logginError,
                enableLoggin = vm.validEmailAndPassword(),
                onLoggin = { vm.loggin() },
            )


        }

    }


}