package com.example.pythoncharmer.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.models.getTopics
import androidx.compose.ui.platform.LocalDensity
import com.example.pythoncharmer.models.Question
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pythoncharmer.R


@Preview(showBackground = true)
@Composable
fun FavoriteIcon(
    topic: Topic = getTopics()[0],
    isFav: Boolean = false,
    onFavClicked: (Topic) -> Unit = {},
){
    IconButton(
        modifier = Modifier.width(80.dp)
            .offset(x = 15.dp, y = (-5).dp)
            .size(50.dp),
        onClick = { onFavClicked(topic) }
    ) {
        Icon(
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .size(50.dp),
            imageVector =
            if (isFav) Icons.Default.Favorite
            else Icons.Default.FavoriteBorder,
            contentDescription = "add to Topics")
    }
}

@Composable
fun singleTopic(topic: Topic,  content: @Composable () -> Unit = {}, onClickItem1 : ( Topic ) -> Unit = {}, onClickItem2 : ( Int ) -> Unit = {}) {

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth(),
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
                    Image(
                        painterResource(R.drawable.snake),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                            .clip(RoundedCornerShape(10.dp))
                            .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)
                    ))
                }

                Column() {
                    Text(text = topic.title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    AnimatedVisibility(
                        visible = true
                    ) {
                        content()
                    }
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
                Image(
                    painterResource(R.drawable.snake),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)
                        ))
            }

            Column() {
                Text(text = topic.title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 15.sp)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun contentBack(
    topic: Topic, questions: List<Question>,
    onClickItem1 : ( Topic ) -> Unit = {},
    onClickItem2 : (Int ) -> Unit = {},
    content: @Composable () -> Unit = {}) {
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
            ) {
                Image(
                    painterResource(R.drawable.snake),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)
                        ))
            }

            Column() {
                Text(text = topic.title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                //Text(text = "Complexity level: ${topic.complexityLevel}", fontSize = 12.sp)
                Text(text = "Get to know the subject or challenge your knowledge", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            onClickItem2(topic.id)
                        },
                        border = BorderStroke(2.dp, Color.DarkGray),
                        //colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red, backgroundColor = Color.LightGray)
                    ) {
                        Text(text = "Study", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            onClickItem1(topic)
                        },
                        border = BorderStroke(2.dp, Color.DarkGray),
                        //colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red, backgroundColor = Color.LightGray)
                    ) {
                        Text(text = "Test", color = Color.Black)
                    }
                    content()
                }
            }
        }
    }
}


@Composable
fun singleTopicHomeScreen(
    contentFront: @Composable () -> Unit = {},
    contentBack: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {}
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
        },
        back = {
            //content for back
               contentBack()
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
