package com.example.pythoncharmer.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pythoncharmer.R
import com.example.pythoncharmer.models.*
import com.example.pythoncharmer.view_models.TestScreenViewModel
import com.example.pythoncharmer.view_states.TestScreenViewState
import com.example.pythoncharmer.models.Topic
import com.example.pythoncharmer.navigation.AppScreens

@Composable
fun TestScreen(navController: NavController = rememberNavController(), topic : Topic?) {

    val testScreenViewModel : TestScreenViewModel = viewModel()
    if ( topic != null ) {
        testScreenViewModel.fetchQuestionsByTopicId( topicId = topic.id )
    }
    val currentState: State<TestScreenViewState> = testScreenViewModel.viewState.collectAsState()

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
    },
        content = { innerPadding ->
            if (topic != null) {
                Column() {
                    QuizTopAppBar(
                        questionIndex = currentState.value.currentQuestionIndex,
                        totalQuestionsCount = currentState.value.questions.count()
                    ) {
                        //TODO
                    }

                    QuestionContent(
                        question = currentState.value.questions[currentState.value.currentQuestionIndex],
                        onAnswer = { isChecked, answerId ->
                            testScreenViewModel.updateGivenAnswers(
                                isChecked = isChecked,
                                answerId = answerId
                            )
                            testScreenViewModel.changeColorToNeutral()
                        },
                        modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    )
                }
            }
        },
        bottomBar = {
            NavigationButtons(
                enableNext = currentState.value.questions[currentState.value.currentQuestionIndex].enableNext,
                showDone = currentState.value.lastQuestion && currentState.value.questions[currentState.value.currentQuestionIndex].enableNext,
                question = currentState.value.questions[currentState.value.currentQuestionIndex],
                onCheckPressed = {
                    testScreenViewModel.checkIfCorrect()
                },
                onNavigateToTutorial = {
                    if (topic != null) {
                        navController.navigate("${AppScreens.StudyLinksScreen.value}/${topic.id}")
                    }

                },
                onNextPressed = {
                    testScreenViewModel.goToNextQuestion()
                },
                onDontKnowPressed = {
                    testScreenViewModel.showCorrectAnswer()
                }
            )
        }
    )
}

@Composable
fun QuestionContent(
    question : Question,
    onAnswer: ( Boolean, Int ) -> Unit = { b: Boolean, i: Int -> },
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            QuestionTitle(questionTitle = question.questionText, question.feedbackColor)
            Spacer(modifier = Modifier.height(24.dp))

            if(question.questionType == QuestionType.singleChoice) {
                SingleChoiceQuestion(
                    question = question,
                    selectedAnswerId = -1,
                    onAnswerSelected = { isChecked, answerId -> onAnswer( isChecked, answerId) },
                    modifier = Modifier.fillParentMaxWidth()
                )
            } else {
                MultipleChoiceQuestion(
                    question = question,
                    selectedAnswerId = -1,
                    onAnswerSelected = { isChecked, answerId -> onAnswer( isChecked, answerId) },
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
    }
}

@Composable
fun QuestionTitle( questionTitle : String, feedbackColor : String ) {
    val colorBackground = if (MaterialTheme.colors.isLight) {
        MaterialTheme.colors.onSurface.copy(alpha = 0.04f)
    } else {
        MaterialTheme.colors.onSurface.copy(alpha = 0.06f)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (feedbackColor == "GREEN") {
                    Color.Green.copy(alpha = 0.5f)
                } else if (feedbackColor == "RED") {
                    Color.Red.copy(alpha = 0.5f)
                } else {
                    colorBackground
                },
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
    selectedAnswerId: Int,
    onAnswerSelected : (Boolean, Int) -> Unit = { b: Boolean, i: Int -> },
    modifier: Modifier = Modifier
) {
    val radioOptions : List<Answer> = question.answers
    val (selectedOption, onOptionSelected) = remember(selectedAnswerId) {
        mutableStateOf(selectedAnswerId)
    }

    Column(modifier = modifier) {
        radioOptions.forEach { answer ->
            val onClickHandle = {
                onOptionSelected(answer.answerId)
                onAnswerSelected(true, radioOptions.indexOf(answer))
            }

            var optionSelected = (radioOptions.indexOf(answer) == selectedOption) //or
                    //(question.showCorrectAnswer && question.correctAnswerId.contains(answer.answerId) )

            if(question.showCorrectAnswer) {
                optionSelected = false
                optionSelected = question.correctAnswerId.contains(answer.answerId)
            }

            val answerBorderColor = if (optionSelected) {
                if (question.feedbackColor == "GREEN") {
                    Color.Green.copy(alpha = 0.5f)
                } else if (question.convertColorBackToNeutral && question.feedbackColor == "RED") {
                    Color.Red.copy(alpha = 0.5f)
                } else {
                    MaterialTheme.colors.primary.copy(alpha = 0.5f)
                }
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            }
            val answerBackgroundColor = if (optionSelected) {
                if (question.feedbackColor == "GREEN") {
                    Color.Green.copy(alpha = 0.12f)
                } else if (question.convertColorBackToNeutral && question.feedbackColor == "RED") {
                    Color.Red.copy(alpha = 0.12f)
                } else {
                    MaterialTheme.colors.primary.copy(alpha = 0.12f)
                }
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
                            onClick = onClickHandle,
                            enabled = !question.enableNext
                        )
                        .background(answerBackgroundColor)
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(4f),
                        text = answer.answerText
                    )
                    RadioButton(
                        modifier = Modifier.weight(1f),
                        selected = optionSelected,
                        onClick = onClickHandle,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.primary
                        ),
                        enabled = !question.enableNext
                    )
                }
            }
        }
    }
}

@Composable
fun MultipleChoiceQuestion(
    question : Question,
    selectedAnswerId: Int,
    onAnswerSelected : (Boolean, Int) -> Unit = { b: Boolean, i: Int -> },
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        question.answers.forEach { item ->
            val isChecked = remember { mutableStateOf(false) }

            val (selectedOption, onOptionSelected) = remember(selectedAnswerId) {
                mutableStateOf(selectedAnswerId)
            }
            val onClickHandle = {
                onOptionSelected(item.answerId)
                //onOptionSelected(radioOptions.indexOf(answer))
                onAnswerSelected(isChecked.value, question.answers.indexOf(item))
            }
            if (question.showCorrectAnswer) {
                isChecked.value = false
                isChecked.value = question.correctAnswerId.contains(question.answers.indexOf(item))
            }

            val answerBorderColor = if (isChecked.value //or
                //(question.showCorrectAnswer && question.correctAnswerId.contains(question.answers.indexOf(item)) )
            ) {
                if (question.feedbackColor == "GREEN") {
                    Color.Green.copy(alpha = 0.5f)
                } else if (question.convertColorBackToNeutral && question.feedbackColor == "RED") {
                    Color.Red.copy(alpha = 0.5f)
                } else {
                    MaterialTheme.colors.primary.copy(alpha = 0.5f)
                }
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            }
            val answerBackgroundColor = if (isChecked.value //or
                //(question.showCorrectAnswer && question.correctAnswerId.contains(question.answers.indexOf(item)) )
            ) {
                if (question.feedbackColor == "GREEN") {
                    Color.Green.copy(alpha = 0.12f)
                } else if (question.convertColorBackToNeutral && question.feedbackColor == "RED") {
                    Color.Red.copy(alpha = 0.12f)
                } else {
                    MaterialTheme.colors.primary.copy(alpha = 0.12f)
                }
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
                            selected = isChecked.value or //or contains(item.answerId)
                                    (question.showCorrectAnswer && question.correctAnswerId.contains(question.answers.indexOf(item)) ),
                            onClick = {
                                isChecked.value = !isChecked.value
                                onClickHandle()
                            },
                            enabled = !question.enableNext
                        )
                        .background(answerBackgroundColor)
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(4f),
                        text = item.answerText
                    )
                    Checkbox(
                        checked = isChecked.value or
                                (question.showCorrectAnswer && question.correctAnswerId.contains(question.answers.indexOf(item)) ),
                        onCheckedChange = {
                            if (it) {
                                onClickHandle()
                            }
                            isChecked.value = it
                        },
                        enabled = !question.enableNext,
                        colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
                    )
                }
            }
        }
    }
}

@Composable
fun QuizTopAppBar(questionIndex: Int, totalQuestionsCount: Int, onBackPressed: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            TopAppBarTitle(
                questionIndex = questionIndex,
                totalQuestionsCount = totalQuestionsCount,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .align(Alignment.Center)
                    )
        }
    }

        val animatedProgress by animateFloatAsState(
            targetValue = (questionIndex + 1) / totalQuestionsCount.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            backgroundColor = if (!isSystemInDarkTheme()) Color.Black.copy(alpha = 0.12f) else Color.White.copy(alpha = 0.24f)
        )
    }

@Composable
private fun TopAppBarTitle(questionIndex: Int, totalQuestionsCount: Int, modifier: Modifier = Modifier) {
    val indexStyle = MaterialTheme.typography.caption.toSpanStyle().copy(
        fontWeight = FontWeight.Bold
    )
    val totalStyle = MaterialTheme.typography.caption.toSpanStyle()
    val text = buildAnnotatedString {
        withStyle(style = indexStyle) {
            append("${questionIndex + 1} ")
        }
        withStyle(style = totalStyle) {
            append(stringResource(R.string.asker_title_totalquestions, totalQuestionsCount))
        }
    }
    //src/main/res/values/strings.xml
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        modifier = modifier,
    )
}

@Composable
fun NavigationButtons(
    enableNext : Boolean,
    showDone : Boolean,
    question: Question,
    onCheckPressed: () -> Unit,
    onNavigateToTutorial: () -> Unit,
    onNextPressed: () -> Unit,
    onDontKnowPressed: () -> Unit
) {
    Surface(
        elevation = 7.dp,
        modifier = Modifier.fillMaxWidth() // .border(1.dp, MaterialTheme.colors.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                enabled = question.showCorrectAnswer || !enableNext,
                onClick = if (question.showCorrectAnswer)
                    onNavigateToTutorial
                else
                    onCheckPressed
            ) {
                if(question.showCorrectAnswer) {
                    Text(text = stringResource(id = R.string.asker_tutorial))
                } else {
                    Text(text = stringResource(id = R.string.asker_check_button))
                }

            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                enabled = !showDone,
                onClick = if (!question.enableNext)
                    onDontKnowPressed
                else
                    onNextPressed
            ) {
                if (question.enableNext)
                    Text(text = stringResource(id = R.string.asker_nav_next_question))
                else
                    Text(text = stringResource(id = R.string.asker_dont_know))
            }
        }
    }
}





