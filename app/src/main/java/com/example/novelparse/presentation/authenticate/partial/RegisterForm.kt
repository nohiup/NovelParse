package com.example.novelparse.presentation.authenticate.partial

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.novelparse.presentation.authenticate.view_model.AuthViewModel

@Composable
fun RegisterForm(authViewModel: AuthViewModel){
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var confirmPassword by remember { mutableStateOf("")}

    Column (modifier = Modifier.wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.textFieldModifier()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.textFieldModifier()

        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.textFieldModifier()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { authViewModel.register(email, password, confirmPassword) }
        ) {
            Text("Register")
        }
    }

}

