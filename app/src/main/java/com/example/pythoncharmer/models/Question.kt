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
    var givenAnswerId by mutableStateOf(0)
    var givenAnswerIds by mutableStateOf(arrayListOf<Int>())
    var enableNext by mutableStateOf(false)
}

val questionsTopicComments = listOf(
    Question(
        0,
        "How do you insert COMMENTS in Python code?",
        listOf<Answer>(
            Answer("#This is a comment", 0),
            Answer("//This is a comment", 1),
            Answer("/*This is a comment*/", 2),
            Answer("<!--This is a comment-->", 3),
        ),
        listOf(0),
        QuestionType.singeleChoice,
        1
    ),
    Question(
    1,
    "What is correctly commented?",
        listOf<Answer>(
            Answer("<!--print(\"Hello World!\")-->", 0),
            Answer("//print(\"Hello World!\")", 1),
            Answer("\"\"\"print(\"Hello World!\")\"\"\"", 2),
            Answer("<!--This is a comment-->", 3)
        ),
        listOf(32),
        QuestionType.singeleChoice,
        1
    ),
    Question(
    2,
    "How do you insert a multiline comment?",
        listOf<Answer>(
            Answer("\"\"\"myName = \"Neo\"\nmy_age = 37\"\"\"", 0),
            Answer("/*myName = \"Neo\"\nmy_age = 37*/", 1),
            Answer("###myName = \"Neo\"\nmy_age = 37###", 2),
            Answer("#myName = \"Neo\"\n#my_age = 37", 3)
        ),
        listOf(0),
        QuestionType.singeleChoice,
    1
    ),
    Question(
    3,
    "What is true?",
        listOf<Answer>(
            Answer("Comments are non-executable statements in Python.", 0),
            Answer("bla bla", 1),
            Answer("some answer", 2),
            Answer("what?", 3)
        ),
        listOf(0),
        QuestionType.singeleChoice,
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
            Answer("2var", 2),
            Answer("return", 3),
            Answer("v2ar", 4),
            Answer("var2", 5),
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
        QuestionType.singeleChoice,
        2
    ),
    Question(
        2,
        "Which of the following statements assigns the value 100 to the variable x in Python:",
        listOf<Answer>(
            Answer("x = 100", 0),
            Answer("x << 100", 1),
            Answer("let x = 100", 2),
            Answer("x := 100", 3)

        ),
        listOf(0),
        QuestionType.singeleChoice,
        2
    )
)

val allQuestions = questionsTopicComments + questionsTopicVariables






