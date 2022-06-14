package com.example.pythoncharmer.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.TopicType
import com.example.pythoncharmer.screens.*
import com.example.pythoncharmer.view_models.AllQuestionsViewModel
import com.example.pythoncharmer.view_models.BookMarksViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val bookMarksViewModel: BookMarksViewModel = viewModel()
    val allQuestionsViewModel: AllQuestionsViewModel = viewModel()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.value) {

        composable(route= AppScreens.SplashScreen.value){
            SplashScreen(navController)
        }
        composable(AppScreens.HomeScreen.value) {
            HomeScreen(navController = navController,bookMarksViewModel)
        }
        composable(route = AppScreens.BookmarksScreen.value) {
            BookMarksScreen(navController, viewModel = bookMarksViewModel)
        }
        composable(route = AppScreens.AllQuestionsScreen.value) {
            AllQuestionsScreen(navController, viewModel = allQuestionsViewModel)
        }
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
            route= "${AppScreens.TestScreen.value}/{topic}",
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