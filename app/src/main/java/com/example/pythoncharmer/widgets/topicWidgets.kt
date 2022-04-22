package com.example.pythoncharmer.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythoncharmer.models.Topic


@Composable
fun singleTopic(topic: Topic, onClickItem: ( Int ) -> Unit = {}) {
    var showHiddenInfo by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        //.height(if (showHiddenInfo) 250.dp else 130.dp)
        .clickable {
            onClickItem(topic.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                    //shape = RectangleShape,
                    //elevation = 6.dp
                ) {
                    //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile picture")
                    /*
                    AsyncImage(
                        model = movie.images[0],
                        contentDescription = "Movie poster",
                        modifier = Modifier.clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )

                     */
                }
                Column() {
                    Text(text = topic.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text(text = "Director: ${topic.title}", fontSize = 12.sp)
                    Text(text = "Released: ${topic.complexityLevel}", fontSize = 12.sp)
                    AnimatedVisibility(
                        visible = showHiddenInfo
                    ) {
                        Text(
                            text = "Plot: ${movie.plot}", fontSize = 12.sp,
                        )
                    }
                    AnimatedVisibility(
                        visible = showHiddenInfo) {
                        Divider(color = Color.LightGray, thickness = 1.dp,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                    AnimatedVisibility(
                        visible = showHiddenInfo
                    ) {
                        Text(
                            text = "Genre: ${movie.genre}", fontSize = 12.sp,
                        )
                    }
                    AnimatedVisibility(
                        visible = showHiddenInfo
                    ) {
                        Text(
                            text = "Actors: ${movie.actors}", fontSize = 12.sp,
                        )
                    }
                    AnimatedVisibility(
                        visible = showHiddenInfo
                    ) {
                        Text(
                            text = "Rating: ${movie.rating}", fontSize = 12.sp,
                        )
                    }
                    if (showHiddenInfo)
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Hide additional information",
                            modifier = Modifier.clickable { showHiddenInfo = !showHiddenInfo }
                        )
                    else
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Show hidden information",
                            modifier = Modifier.clickable { showHiddenInfo = !showHiddenInfo }
                        )
                }
            }
            AnimatedVisibility(
                visible = showFavoriteIcon
            ) {
                content()
            }
        }
    }
}



