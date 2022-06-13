package com.example.pythoncharmer.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pythoncharmer.models.InMemoryQuestionService
import com.example.pythoncharmer.models.QuestionType
import com.example.pythoncharmer.models.QuestionsXRepository
import com.example.pythoncharmer.view_states.TestScreenViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * The [TestScreenViewModel] takes in a [questionsXRepository] to request data, messages that data
 * into a [TestScreenViewState] that can be exposed by the [viewState] flow in order for the
 * view to render the relevant information
 */
class TestScreenViewModel(
    private val questionsXRepository: QuestionsXRepository = InMemoryQuestionService()
) : ViewModel() {
    //only view model should be able to manipulate state
    private val _viewState = MutableStateFlow(TestScreenViewState())
    //this public state anybody can listen to
    val viewState : StateFlow<TestScreenViewState> = _viewState

    init {
        fetchQuestions()
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            val questions = questionsXRepository.fetchQuestions()
            _viewState.value = _viewState.value.copy(
                questions = questions
            )
        }
    }

    fun fetchQuestionsByTopicId( topicId : Int ) {
        viewModelScope.launch {
            val questions = questionsXRepository.fetchQuestionsById( topicId = topicId );
            _viewState.value = _viewState.value.copy(
                questions = questions
            )
        }
    }

    fun updateGivenAnswers( isChecked : Boolean, answerId : Int ) {
        if (_viewState.value.questions[_viewState.value.currentQuestionIndex].questionType == QuestionType.multipleChoice) {
            if (isChecked) {
                _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.add(answerId)
            } else if (_viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.contains(answerId)) {
                _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.remove(answerId)
            }
        } else {
            _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.clear()
            _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.add(answerId)
        }
    }

    fun goToNextQuestion() {
        val lastQuestionIndex = _viewState.value.questions.lastIndex
        val currentIndex = _viewState.value.currentQuestionIndex
        if (currentIndex < lastQuestionIndex) {
            if(lastQuestionIndex - currentIndex == 1) {
                _viewState.value.lastQuestion = true
            }
            Log.d("Go Next Question", "Going from " + currentIndex + " to " + currentIndex +1)
            _viewState.value.currentQuestionIndex = _viewState.value.currentQuestionIndex + 1
        }

    }

    fun checkIfCorrect() {
        if (_viewState.value.questions[_viewState.value.currentQuestionIndex].correctAnswerId.containsAll(
                _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds
            ) && _viewState.value.questions[_viewState.value.currentQuestionIndex].correctAnswerId.size
            == _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.size
        ) {
            _viewState.value.questions[_viewState.value.currentQuestionIndex].enableNext = true
            _viewState.value.questions[_viewState.value.currentQuestionIndex].feedbackColor = "GREEN"
            viewState.value.questions[_viewState.value.currentQuestionIndex].convertColorBackToNeutral = false
        } else {
            _viewState.value.questions[_viewState.value.currentQuestionIndex].convertColorBackToNeutral = true
            _viewState.value.questions[_viewState.value.currentQuestionIndex].feedbackColor = "RED"
        }
    }

    fun changeColorToNeutral() {
        viewState.value.questions[_viewState.value.currentQuestionIndex].convertColorBackToNeutral = false
    }

    fun showCorrectAnswer() {
        _viewState.value.questions[_viewState.value.currentQuestionIndex].enableNext = true
        _viewState.value.questions[_viewState.value.currentQuestionIndex].showCorrectAnswer = true
        _viewState.value.questions[_viewState.value.currentQuestionIndex].feedbackColor = "GREEN"
        viewState.value.questions[_viewState.value.currentQuestionIndex].convertColorBackToNeutral = false
    }
}