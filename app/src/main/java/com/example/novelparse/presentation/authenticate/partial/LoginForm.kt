package com.example.novelparse.presentation.authenticate.partial

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novelparse.presentation.authenticate.view_model.AuthViewModel
import com.example.novelparse.ui.theme.SepiaLight
import com.example.novelparse.ui.theme.SepiaPrimary

@Composable
fun LoginForm(authViewModel: AuthViewModel, navController: NavController){
    val email by authViewModel.email.collectAsState()
    val password by authViewModel.password.collectAsState()
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    LaunchedEffect(isLoggedIn){
        if(isLoggedIn){
            navController.navigate("home")
        }
    }
    Column (
        modifier = Modifier.wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        TextField (
            value = email,
            onValueChange = { authViewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.textFieldModifier(),
            colors = TextFieldColors()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField (
            value = password,
            onValueChange = { authViewModel.onPasswordChange(it) },
            label = { Text("Password") },
            modifier = Modifier.textFieldModifier(),
            colors = TextFieldColors()

        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                authViewModel.login()
                navController.navigate("home"){
                    popUpTo("auth"){
                        inclusive = true
                    }
                }
            }
        ) {
            Text("Login")
        }
    }
}