package com.example.pythoncharmer.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.getTopics
import com.example.pythoncharmer.navigation.AppScreens
import com.example.pythoncharmer.view_models.BookMarksViewModel
import com.example.pythoncharmer.widgets.*

@Composable
fun HomeScreen(navController: NavController, viewModel: BookMarksViewModel) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Python Charmer") },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More" )
                    }
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = {
                            navController.navigate(AppScreens.BookmarksScreen.value)
                        }) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Bookmarks",
                                    modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "Bookmarks",
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .width(125.dp)
                                )
                            }
                        }
                    }
                }
            )
        }
    ) {
        //MainContent(getTopics(), navController = navController, favViewModel = viewModel)
        HomeScreenContent(getTopics(), navController = navController, bookMarksViewModel = viewModel)
    }

}

@Composable
fun HomeScreenContent(topics : List<Topic>, navController: NavController, bookMarksViewModel: BookMarksViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
       LazyColumn {
           /*
           items( topics ) { topic ->
                singleTopic(topic = topic,
                    onClickItem1 = {
                        topic -> navController.navigate("${AppScreens.MultipleChoiceExercise.value}/${topic}")
                    }
                    //onClickItem = { topicId -> navController.navigate(AppScreens.StudylinksScreen.value +"/$topicId")}

                    ) { topicId ->
                    navController.navigate(AppScreens.StudylinksScreen.value +"/$topicId")
                }
            }
            */
           items( topics ) { topic ->
              singleTopicHomeScreen(
                  contentFront = {
                      contentFront(topic = topic)
                  },
                  contentBack = {
                      contentBack(
                          topic = topic,
                          questions = topic.questions,
                          onClickItem1 = {
                              topic ->  navController.navigate("${AppScreens.TestScreen.value}/${topic}")
                              /*
                                         topic: Topic, questions: Questions ->  run {
                              navController.navigate("${AppScreens.TestScreen.value}/${topic}/${questions}")
                          }

                               */
                                  //topic, questions ->  navController.navigate("${AppScreens.TestScreen.value}/${topic}/${questions}")
                          },
                          onClickItem2 = {
                              topicId -> navController.navigate("${AppScreens.StudyLinksScreen.value}/${topicId}")
                          }
                      ){
                          FavoriteIcon(
                              topic = topic,
                              isFav = bookMarksViewModel.isFavorite(topic)
                          ){ m ->
                              if(bookMarksViewModel.isFavorite(m)){
                                  bookMarksViewModel.removeFromBookMarks(m)
                              } else {
                                  bookMarksViewModel.addToBookMarks(m)
                              }
                          }
                      }
                  }
              )
           }

           // topics.forEach { topic -> singleTopic(name = topic.title) }
        }

    }
}




