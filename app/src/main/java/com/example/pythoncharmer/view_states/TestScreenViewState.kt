package com.example.pythoncharmer.view_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.pythoncharmer.models.Question

/**
 * This class represents the view state for the test screen. All of this data
 * should be formatted in a way that the test screen can just take the information
 * and display it.
 */
data class TestScreenViewState(
    val questions : List<Question> = emptyList()
) {
    var currentQuestionIndex by mutableStateOf( 0 )
    var lastQuestion by mutableStateOf(false)
    var testFinished by mutableStateOf(false)
    var numberCorrectAnsweredQuestions by mutableStateOf(0) //to count
}
