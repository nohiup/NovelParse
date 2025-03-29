package com.example.novelparse.presentation.authenticate

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.semantics.Role.Companion.Tab
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.novelparse.domain.entity.AuthModel
import com.example.novelparse.presentation.Navigation
import com.example.novelparse.presentation.authenticate.partial.LoginForm
import com.example.novelparse.presentation.authenticate.partial.RegisterForm
import com.example.novelparse.presentation.authenticate.view_model.AuthViewModel

@Composable
fun AuthScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        AuthContent(navController, authViewModel)
    }
}

@Composable
fun AuthContent(navController: NavController, authViewModel: AuthViewModel){
    var selectedTab by remember {
        mutableStateOf(0)
    }

    Column (modifier = Modifier.fillMaxWidth().padding(16.dp).wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        TabRow(selectedTabIndex = selectedTab) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Login", color = Color.White) }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Register", color = Color.White) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        when(selectedTab){
            0 -> LoginForm(authViewModel = authViewModel, navController = navController)
            1 -> RegisterForm(authViewModel = authViewModel)
        }
    }
}