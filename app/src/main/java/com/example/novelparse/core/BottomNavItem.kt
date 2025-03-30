package com.example.novelparse.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Filled.Home, "Home")
    data object Favorite : BottomNavItem("favorite", Icons.Filled.Favorite, "Favorite")
    data object Personal : BottomNavItem("personal", Icons.Filled.Person, "Personal")
    data object Setting : BottomNavItem("setting", Icons.Filled.Settings, "Setting")
}
