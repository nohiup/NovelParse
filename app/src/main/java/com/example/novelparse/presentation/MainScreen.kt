package com.example.novelparse.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.novelparse.core.BottomNavItem
import com.example.novelparse.core.partial.BottomNavigationBar
import com.example.novelparse.presentation.home.HomeScreen


@Composable
fun MainScreen() {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavController) }
    ) { paddingValues ->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen(bottomNavController) }
            composable(BottomNavItem.Favorite.route) { FavoriteScreen(bottomNavController) }
            composable(BottomNavItem.Personal.route) { PersonalScreen(bottomNavController) }
            composable(BottomNavItem.Setting.route) { SettingScreen(bottomNavController) }
        }
    }
}


@Composable
fun FavoriteScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Favorite Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PersonalScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Personal Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SettingScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Setting Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}