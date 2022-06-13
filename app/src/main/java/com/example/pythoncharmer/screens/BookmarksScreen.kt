package com.example.pythoncharmer.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.getTopics

import com.example.pythoncharmer.view_models.BookMarksViewModel
import com.example.pythoncharmer.widgets.SimpleTopAppBar
import com.example.pythoncharmer.widgets.singleTopicHomeScreen

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