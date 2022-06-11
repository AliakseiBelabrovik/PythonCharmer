package com.example.pythoncharmer.models

/**
 * [QuestionsXRepository] serves as the model layer for our test screen. This allows us to
 * request themes and garden items.
 * We use an interface so that we can create multiple implementations and swap them out.
 */
interface QuestionsXRepository {

    suspend fun fetchQuestions() : List<Question>
}