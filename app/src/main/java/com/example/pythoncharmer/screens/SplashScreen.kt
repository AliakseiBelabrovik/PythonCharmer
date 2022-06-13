package com.example.pythoncharmer.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pythoncharmer.R
import com.example.pythoncharmer.navigation.AppScreens
import com.example.pythoncharmer.ui.theme.Purple700
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 4000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.navigate(AppScreens.HomeScreen.value)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple700),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painterResource(R.drawable.snake),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .offset(x = 25.dp)
                    .size(200.dp)
                    .alpha(alpha)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Welcome to PythonCharmer", color = Color.White, fontSize = 20.sp)
        }

    }


}