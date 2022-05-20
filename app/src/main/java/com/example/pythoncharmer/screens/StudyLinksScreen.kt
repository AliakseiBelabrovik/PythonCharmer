package com.example.pythoncharmer.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.getTopics
import com.example.pythoncharmer.widgets.SimpleTopAppBar
import com.example.pythoncharmer.widgets.singleTopic


fun filterTopic(topicID: Int?): Topic {
    return getTopics().filter { it.id == topicID}[0]
}

@Composable
fun StudyLinksScreen(navController: NavController,  topicID: Int?){
    val topic = filterTopic(topicID = topicID)

    Scaffold(
        topBar = {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
                Text(text = topic.title)
            }
        }
    ) {
        MainContent(topic = topic)
    }
}

@Composable
fun MainContent(topic: Topic){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            singleTopic(topic = topic) {

            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = "${topic.title}", style = MaterialTheme.typography.h5)
            val uriHandler = LocalUriHandler.current
            LazyColumn(){
                itemsIndexed(topic.studyLinks){index,item ->
                    Text(modifier = Modifier.clickable { uriHandler.openUri("$item") }, text="Link ${index+1} ")
                }
            }
        }
    }
}
