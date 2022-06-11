package com.example.pythoncharmer.models

/**
 * Data layer - concrete implementation of the model layer
 */
class InMemoryQuestionService : QuestionsXRepository {

    override suspend fun fetchQuestions(): List<Question> {
        return questionsTopicComments
    }
}