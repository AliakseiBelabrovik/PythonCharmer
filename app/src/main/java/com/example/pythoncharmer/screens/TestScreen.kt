package com.example.pythoncharmer.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pythoncharmer.models.*

@Composable
fun TestScreen(navController: NavController = rememberNavController(), topic : Topic?) {
        val questions = Questions(
            getQuestionStates()
        )

        val questionState = remember(questions.currentQuestionIndex) {
            questions.questionsState[questions.currentQuestionIndex]
        }
        Scaffold(topBar = {
            TopAppBar() {
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {
                            navController.navigateUp()
                            //navController.popBackStack()
                        }
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "Test to " + topic?.title ?: "")
                }
            }
        }) { innerPadding ->
            if (topic != null) {
                //MainContent(topic = topic, navController = navController)
                QuestionContent(
                    question = questionState.question,
                    selectedAnswer = questionState.givenAnswerId,
                    onAnswer = {
                        questionState.givenAnswerId = it
                        questionState.enableNext = true
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }

}
/*
content = { innerPadding ->
                QuestionContent(
                    question = questionState.question,
                    selectedAnswer = questionState.givenAnswerId,
                    onAnswer = {
                        questionState.givenAnswerId = it.id
                        questionState.enableNext = true
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            },
 */

@Composable
fun QuestionContent(
    question : Question,
    selectedAnswer : String,
    onAnswer: ( String ) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            QuestionTitle(questionTitle = question.question)
            Spacer(modifier = Modifier.height(24.dp))

            SingleChoiceQuestion(
                question = question,
                selectedAnswer = selectedAnswer,
                onAnswerSelected = { answer -> onAnswer(answer) },
                modifier = Modifier.fillParentMaxWidth()
            )
        }
    }
}


@Composable
fun QuestionTitle( questionTitle : String ) {
    val colorBackground = if (MaterialTheme.colors.isLight) {
        MaterialTheme.colors.onSurface.copy(alpha = 0.04f)
    } else {
        MaterialTheme.colors.onSurface.copy(alpha = 0.06f)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorBackground,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Text(
            text = questionTitle,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun SingleChoiceQuestion(
    question : Question,
    selectedAnswer: String = "",
    onAnswerSelected : (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val radioOptions : List<String> = question.correctAnswer + question.wrongAnswer
    val (selectedOption, onOptionSelected) = remember(selectedAnswer) {
        mutableStateOf(selectedAnswer)
    }

    Column(modifier = modifier) {
        radioOptions.forEach { answer ->
            val onClickHandle = {
                onOptionSelected("${radioOptions.indexOf(answer)}")
                onAnswerSelected("${radioOptions.indexOf(answer)}")
            }

            val optionSelected = "${radioOptions.indexOf(answer)}" == selectedOption
            val answerBorderColor = if (optionSelected) {
                MaterialTheme.colors.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            }
            val answerBackgroundColor = if (optionSelected) {
                MaterialTheme.colors.primary.copy(alpha = 0.12f)
            } else {
                MaterialTheme.colors.background
            }
            Surface(
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    width = 1.dp,
                    color = answerBorderColor
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = optionSelected,
                            onClick = onClickHandle
                        )
                        .background(answerBackgroundColor)
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(4f),
                        text = answer
                    )
                    RadioButton(
                        modifier = Modifier.weight(1f),
                        selected = optionSelected,
                        onClick = onClickHandle,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.primary
                        )
                    )

                }
            }

        }
    }









}


