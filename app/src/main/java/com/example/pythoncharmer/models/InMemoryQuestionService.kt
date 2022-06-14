package com.example.pythoncharmer.models

/**
 * Data layer - concrete implementation of the model layer
 */
class InMemoryQuestionService : QuestionsXRepository {

    override suspend fun fetchQuestions(): List<Question> {
        return questionsTopicComments
    }

    override suspend fun fetchQuestionsById(topicId: Int): List<Question> {
        return allQuestions.filter { question -> question.topicId == topicId }
    }

    override suspend fun fetchAllQuestions(): List<Question> {
        return shuffledQuestions
    }


}