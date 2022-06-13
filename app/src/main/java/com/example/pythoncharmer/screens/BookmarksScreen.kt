package com.example.pythoncharmer.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import com.example.pythoncharmer.models.Topic

import com.example.pythoncharmer.view_models.BookMarksViewModel
import com.example.pythoncharmer.widgets.SimpleTopAppBar

@Composable
fun BookMarksScreen(navController: NavController, viewModel: BookMarksViewModel){
    Scaffold(topBar = {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = "My Bookmarked Topics")
        }
    }){
        MainContentBookMarks(topicList = viewModel.bookMarkedTopic, navController = navController, viewModel)
    }
}

@Composable
fun MainContentBookMarks(topicList: List<Topic>, navController: NavController, viewModel: BookMarksViewModel){
    //Column(modifier = Modifier.padding(12.dp)) {
        //LazyColumn {
            //items(items = topicList){ topic ->
                HomeScreenContent(topics = topicList, navController = navController, bookMarksViewModel = viewModel)
            //}
        //}
    //}
}