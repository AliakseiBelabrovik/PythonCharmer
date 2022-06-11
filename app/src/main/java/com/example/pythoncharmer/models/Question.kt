package com.example.pythoncharmer.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Question(
    val questionId: Int,
    val questionText: String,
    val answers: List<Answer>,
    val correctAnswerId: Int,
    val questionType: QuestionType,
    val topicId: Int
) {
    var givenAnswerId by mutableStateOf(0)
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
        1,
        QuestionType.singeleChoice,
        1
    ),
    Question(
    1,
    "What is correctly commented?",
        listOf<Answer>(
            Answer("<!--print(\"Hello World!\")-->", 1),
            Answer("//print(\"Hello World!\")", 2),
            Answer("\"\"\"print(\"Hello World!\")\"\"\"", 3),
            Answer("<!--This is a comment-->", 4)
        ),
        3,
        QuestionType.singeleChoice,
        1
    ),
    Question(
    2,
    "How do you insert a multiline comment?",
        listOf<Answer>(
            Answer("\"\"\"myName = \"Neo\"\nmy_age = 37\"\"\"", 1),
            Answer("/*myName = \"Neo\"\nmy_age = 37*/", 2),
            Answer("###myName = \"Neo\"\nmy_age = 37###", 3),
            Answer("#myName = \"Neo\"\n#my_age = 37", 4)
        ),
        1,
        QuestionType.singeleChoice,
    1
    ),
    Question(
    3,
    "What is true?",
        listOf<Answer>(
            Answer("Comments are non-executable statements in Python.", 1),
            Answer("bla bla", 2),
            Answer("some answer", 3),
            Answer("what?", 4)
        ),
        1,
        QuestionType.singeleChoice,
        1
    )
)






