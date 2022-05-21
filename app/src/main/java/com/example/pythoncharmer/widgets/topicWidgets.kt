package com.example.pythoncharmer.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.*
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.getTopics
import androidx.compose.ui.platform.LocalDensity


@Composable
fun singleTopic(topic: Topic,  content: @Composable () -> Unit = {}, onClickItem1 : ( Topic ) -> Unit = {}, onClickItem2 : ( Int ) -> Unit = {}) {
    var showHiddenInfo by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth(),
        //.height(if (showHiddenInfo) 250.dp else 130.dp)
            /*
        .clickable {
            onClickItem(topic.id)
        },

             */
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
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile picture")
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
                    Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    AnimatedVisibility(
                        visible = true
                    ) {
                        content()
                    }

                    /*
                    AnimatedVisibility(
                        visible = showHiddenInfo
                    ) {
                        Text(
                            text = "Topic Id: ${topic.id}", fontSize = 12.sp,
                        )
                    }
                    /*AnimatedVisibility(
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
                    }*/
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

                     */

                }


            }
        }
    }
}

@Composable
fun contentFront(topic: Topic) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                //shape = RectangleShape,
                //elevation = 6.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile picture")
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
                Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 12.sp)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun contentBack(topic: Topic,  content: @Composable () -> Unit = {}, onClickItem1 : ( Topic ) -> Unit = {}, onClickItem2 : ( Int ) -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                //shape = RectangleShape,
                //elevation = 6.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile picture")
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
                Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 12.sp)
                Text(text = "Get to know the subject or challenge your knowledge", fontSize = 12.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            onClickItem2(topic.id)
                        },
                        border = BorderStroke(0.5.dp, Color.Red),
                        //colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                    ) {
                        Text(text = "Study", color = Color.DarkGray)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            onClickItem1(topic)
                        },
                        border = BorderStroke(0.5.dp, Color.Red),
                        //colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                    ) {
                        Text(text = "Test", color = Color.DarkGray)
                    }
                }
            }
        }
    }
}


@Composable
fun singleTopicHomeScreen(
    contentFront: @Composable () -> Unit = {},
    contentBack: @Composable () -> Unit = {}
) {
    var cardFace by remember {
        mutableStateOf(CardFace.Front)
    }
    FlipCard(cardFace = cardFace,
        onClick = { cardFace = cardFace.next },
        modifier = Modifier
            .fillMaxWidth(1f)
            //.fillMaxWidth()
            //.aspectRatio(1f)
            .padding(4.dp),
        front = {
            //content for front
                contentFront()
            /*
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Front",
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
            }

             */
        },
        back = {
            //content for back
               contentBack()



            /*
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Back",
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
            }

             */
        },
        topic = getTopics()[0]
    )

}

//Composable signature
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlipCard(
    cardFace: CardFace,
    onClick : (CardFace) -> Unit,
    modifier : Modifier = Modifier,
    back: @Composable () -> Unit = {},
    front: @Composable () -> Unit = {},
    topic: Topic,  content: @Composable () -> Unit = {}, onClickItem1 : ( Topic ) -> Unit = {}, onClickItem2 : ( Int ) -> Unit = {}
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle, //indicates what value we are animating to
        animationSpec = tween( //how we animate t that target value
            durationMillis = 400,
            easing = FastOutSlowInEasing //i.e. animation starts fast, then slows down and stops
        )
    )

    Card(
        onClick = {   onClick(cardFace) },
        modifier = modifier
            .graphicsLayer(
                rotationY = rotation.value,
                cameraDistance = with(LocalDensity.current) { 12f.dp.toPx() } //converts 12 dp to pixels
            ), //we use graphicsLayer for better performance
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        if( rotation.value <= 90f ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                front()
            }

        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = 180f
                    }
            ) {
                back()
            }
        }
    }
}
/*
//TestCode
@Composable
fun testFun() {
    var cardFace by remember {
        mutableStateOf(CardFace.Front)
    }
    FlipCard(cardFace = cardFace,
        onClick = { cardFace = cardFace.next },
        modifier = Modifier
            .fillMaxWidth(.5f)
            .aspectRatio(1f),
        front = {
            //content for front
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Front",
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
            }
        },
        back = {
            //content for back
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Back",
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
            }
        },
        topic = getTopics()[0]
    )

}
*/
