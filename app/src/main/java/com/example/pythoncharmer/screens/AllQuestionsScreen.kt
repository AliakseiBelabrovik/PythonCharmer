package com.example.pythoncharmer.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pythoncharmer.view_states.TestScreenViewState
import com.example.pythoncharmer.view_models.AllQuestionsViewModel

@Composable
fun AllQuestionsScreen(navController: NavController = rememberNavController(), viewModel: AllQuestionsViewModel) {

    val allQuestionsViewModel : AllQuestionsViewModel = viewModel()
    val currentState: State<TestScreenViewState> = allQuestionsViewModel.viewState.collectAsState()

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
                Text(text = "All Questions",
                modifier = Modifier.offset(x = 130.dp))
                Spacer(modifier = Modifier.width(20.dp))

            }
        }
    },
        content = { innerPadding ->
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
                        allQuestionsViewModel.updateGivenAnswers(
                            isChecked = isChecked,
                            answerId = answerId
                        )
                        allQuestionsViewModel.changeColorToNeutral()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        },
        bottomBar = {
            NavigationButtons(
                enableNext = currentState.value.questions[currentState.value.currentQuestionIndex].enableNext,
                showDone = currentState.value.lastQuestion && currentState.value.questions[currentState.value.currentQuestionIndex].enableNext,
                question = currentState.value.questions[currentState.value.currentQuestionIndex],
                onCheckPressed = {
                    allQuestionsViewModel.checkIfCorrect()
                },
                onNavigateToTutorial = {
                },
                onNextPressed = {
                    allQuestionsViewModel.goToNextQuestion()
                },
                onDontKnowPressed = {
                    allQuestionsViewModel.showCorrectAnswer()
                }
            )
        }
    )
}