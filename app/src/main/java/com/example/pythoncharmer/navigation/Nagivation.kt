package com.example.pythoncharmer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pythoncharmer.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.value) {
        composable(AppScreens.HomeScreen.value) { HomeScreen(navController = navController) }
        //composable(AppScreens.TutorialScreen) {  }
    }


}