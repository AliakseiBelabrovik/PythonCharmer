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
                Log.d("Adding the answer",
                    "Adding the answer " +
                            _viewState.value.questions[_viewState.value.currentQuestionIndex].answers[answerId].answerText)
                Log.d("The given answers are",
                    "The given answers are " + _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds )
            } else if (_viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.contains(answerId)) {
                _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds.remove(answerId)
                Log.d("Removing the answer",
                    "Removing the answer " +
                            _viewState.value.questions[_viewState.value.currentQuestionIndex].answers[answerId].answerText)
                Log.d("The given answers are",
                    "The given answers are " + _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerIds )
            }
        } else {
            _viewState.value.questions[_viewState.value.currentQuestionIndex].givenAnswerId = answerId
            Log.d("Changed answer",
                "The answer selected is " +
                        _viewState.value.questions[_viewState.value.currentQuestionIndex].answers[answerId].answerText)
        }
    }
}