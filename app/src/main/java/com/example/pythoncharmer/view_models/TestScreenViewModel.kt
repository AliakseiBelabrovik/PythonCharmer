package com.example.pythoncharmer.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pythoncharmer.models.InMemoryQuestionService
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
    //now we need to update that state with the actual data we request
    private fun fetchQuestions() {
        viewModelScope.launch {
            val questions = questionsXRepository.fetchQuestions()
            _viewState.value = _viewState.value.copy(
                questions = questions
            )
        }
    }

    public fun fetchQuestionsByTopicId( topicId : Int ) {

    }



}