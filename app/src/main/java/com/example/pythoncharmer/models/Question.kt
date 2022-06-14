package com.example.pythoncharmer.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Question(
    val questionId: Int,
    val questionText: String,
    val answers: List<Answer>,
    val correctAnswerId: List<Int>,
    val questionType: QuestionType,
    val topicId: Int
) {
    var givenAnswerIds by mutableStateOf(arrayListOf<Int>())
    var enableNext by mutableStateOf(false)
    var feedbackColor by mutableStateOf("NEUTRAL")
    var convertColorBackToNeutral by mutableStateOf(false)
    var showCorrectAnswer by mutableStateOf(false)
}

val questionsTopicComments = listOf(
    Question(
        0,
        "How does a single line comment look like?",
        listOf<Answer>(
            Answer("# This is a comment", 0),
            Answer("// This is a comment", 1),
            Answer("/* This is a comment */", 2),
            Answer("<!--This is a comment-->", 3),
        ),
        listOf(0),
        QuestionType.singleChoice,
        1
    ),
    Question(
    1,
    "How does One-line docstring look like?",
        listOf<Answer>(
            Answer("<!--print(\"Hello World!\")-->", 0),
            Answer("// print(\"Hello World!\")", 1),
            Answer("\"\"\" print(\"Hello World!\") \"\"\"", 2),
            Answer("<!--This is a comment-->", 3)
        ),
        listOf(2),
        QuestionType.singleChoice,
        1
    ),
    Question(
    2,
    "How do you insert a multiline comment?",
        listOf<Answer>(
            Answer("\"\"\"\n myName = \"Neo\"\nmy_age = 37 \n\"\"\"", 0),
            Answer("/* myName = \"Neo\"\nmy_age = 37 */", 1),
            Answer("### myName = \"Neo\"\nmy_age = 37 ###", 2),
            Answer("# myName = \"Neo\"\n# my_age = 37", 3)
        ),
        listOf(0,3),
        QuestionType.multipleChoice,
    1
    ),
    Question(
    3,
    "Choose all statements that are True.",
        listOf<Answer>(
            Answer("Long comments provide more information and are therefore preferred", 0),
            Answer("Comments are non-executable statements in Python.", 1),
            Answer("You need as many comments as possible, even if they are redundant", 2),
            Answer("Comments should describe, how the function does what it does", 3),
            Answer("Make comments as short and informative as possible.", 4),
            ),
        listOf(1,4),
        QuestionType.multipleChoice,
        1
    )
)

val questionsTopicVariables = listOf(
    Question(
        0,
        "Which of the following are valid Python variable names:",
        listOf<Answer>(
            Answer("var1.4", 0),
            Answer("var_2", 1),
            Answer("return", 2),
            Answer("2var", 3),
            Answer("v2ar", 4),
            Answer("var2", 5)
        ),
        listOf(1, 4, 5),
        QuestionType.multipleChoice,
        2
    ),
    Question(
        1,
        "In Python, a variable must be declared before it is assigned a value:",
        listOf<Answer>(
            Answer("True", 0),
            Answer("False", 1)
        ),
        listOf(1),
        QuestionType.singleChoice,
        2
    ),
    Question(
        2,
        "Which of the following statements assigns the value 100 to the variable x in Python:",
        listOf<Answer>(
            Answer("x << 100", 0),
            Answer("let x = 100", 1),
            Answer("x = 100", 2),
            Answer("x := 100", 3),
            Answer("x <- 100", 4)
        ),
        listOf(0),
        QuestionType.singleChoice,
        2
    ),
    Question(
        3,
        "In Python, a variable may be assigned a value of one type, and then later assigned a value of a different type:",
        listOf<Answer>(
            Answer("True", 0),
            Answer("False", 1)
        ),
        listOf(0),
        QuestionType.singleChoice,
        2
    ),
    Question(
        4,
        "Which of the following styles does PEP8 recommend for multi-word variable names:",
        listOf<Answer>(
            Answer("DistanceToNearestTown (Pascal Case)", 0),
            Answer("distanceToNearestTown (Camel Case)", 1),
            Answer("distance_to_nearest_town (Snake Case)", 2),
            ),
        listOf(2),
        QuestionType.singleChoice,
        2
    ),
)

val allQuestions = questionsTopicComments + questionsTopicVariables
val shuffledQuestions = allQuestions.shuffled()






