package com.example.pythoncharmer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.TopicType
import com.example.pythoncharmer.screens.HomeScreen
import com.example.pythoncharmer.screens.TestScreen
import com.example.pythoncharmer.screens.StudyLinksScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.value) {
        composable(AppScreens.HomeScreen.value) { HomeScreen(navController = navController) }
        composable(
            route = AppScreens.StudyLinksScreen.value+"/{TopicId}",// placeholder for arguments
            arguments = listOf(navArgument(name = "TopicId"){   // define arguments that can be passed
                type = NavType.IntType
            } ) ) { navBackStackEntry ->
            StudyLinksScreen(
                navController = navController,
                topicID = navBackStackEntry.arguments?.getInt("TopicId") // pass the value of movieId argument to the DetailScreen composable
            )
        }
        composable(
            route= "${AppScreens.TestScreen.value}/{topic}/{questions}",
            arguments = listOf(
                navArgument(name = "topic") {
                    type = TopicType()
                }
            )
        ) { navBackStackEntry ->
            TestScreen(
                navController = navController,
                topic = navBackStackEntry.arguments?.getParcelable<Topic>("topic")
            )
        }
    }



}