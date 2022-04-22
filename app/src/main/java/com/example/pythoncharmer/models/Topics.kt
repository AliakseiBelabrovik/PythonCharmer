package com.example.pythoncharmer.models

data class Topic (
    val id : Int,
    val title: String,
    val complexityLevel: String,
    //val precedingTopic: String,
    //val followingTopic: String,
    val multipleChoiceQuestions: List<String>,
    val singleChoiceQuestions: List<String>
    )

fun getTopics() : List<Topic> {
    return listOf(
        Topic(
            id = 1,
            title = "Comments",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
            ),
        Topic(
            id = 2,
            title = "Variables",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),Topic(
            id = 3,
            title = "Data types",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 4,
            title = "Numbers",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 5,
            title = "Strings",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 6,
            title = "Operators",
            complexityLevel = "easy",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 7,
            title = "Lists",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 8,
            title = "Dictionaries",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 9,
            title = "If...else",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 10,
            title = "While & For Loops",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 11,
            title = "Functions",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 12,
            title = "Lambda functions",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 13,
            title = "Arrays",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 14,
            title = "Objects",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 15,
            title = "Inheritance",
            complexityLevel = "medium",
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        )
    )
}