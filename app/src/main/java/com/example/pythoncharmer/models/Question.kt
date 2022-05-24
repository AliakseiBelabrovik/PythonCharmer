package com.example.pythoncharmer.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Question(
    val id: Int,
    val question: String,
    val correctAnswer: List<String>,
    val wrongAnswer: List<String>,
    val questionType: Questiontype,
    val topic: Int
) {
}


data class Questions(
    val questionsState : List<QuestionState>
) {
    var currentQuestionIndex by mutableStateOf(0)
}

class QuestionState(
    val question : Question,
    val questionIndex : Int,
    val totalQuestions : Int,
    val showPrevious : Boolean,
    val showDone : Boolean
) {
    var enableNext by mutableStateOf(false)
    var givenAnswerId by mutableStateOf("")
}

fun getQuestionStates() : List<QuestionState> {
    return listOf(
        QuestionState(
            question = getQuestions()[0],
            questionIndex = 0,
            totalQuestions = 5,
            showPrevious = false,
            showDone = false
        ),
        QuestionState(
            question = getQuestions()[1],
            questionIndex = 1,
            totalQuestions = 5,
            showPrevious = false,
            showDone = false
        ),
        QuestionState(
            question = getQuestions()[2],
            questionIndex = 2,
            totalQuestions = 5,
            showPrevious = false,
            showDone = false
        ),
        QuestionState(
            question = getQuestions()[3],
            questionIndex = 3,
            totalQuestions = 5,
            showPrevious = false,
            showDone = false
        ),
        QuestionState(
            question = getQuestions()[4],
            questionIndex = 4,
            totalQuestions = 5,
            showPrevious = false,
            showDone = false
        )
    )
}


fun getQuestions() : List<Question> {
        return listOf(
            Question(
              1,
              "How do you insert COMMENTS in Python code?",
              listOf("#This is a comment"),
              listOf("//This is a comment","/*This is a comment","<!--This is a comment-->"),
                Questiontype.singeleChoice,
                1
            ),
            Question(
                2,
                "What is correctly commented?",
                listOf("\"\"\"print(\"Hello World!\")\"\"\"","#print(\"Hello World!\")"),
                listOf("<!--print(\"Hello World!\")-->","//print(\"Hello World!\")"),
                Questiontype.multipleChoice,
                1
            ),
            Question(
                3,
                "Testfrage",
                listOf("ist richtig","auchRichtig","nohcmal Richtig"),
                listOf("falsch"),
                Questiontype.multipleChoice,
                1
            ),
            Question(
                4,
                "How do you insert a multiline comment?",
                listOf("\"\"\"myName = \"Neo\"\nmy_age = 37\"\"\""),
                listOf(
                    "/*myName = \"Neo\"\nmy_age = 37*/",
                    "###myName = \"Neo\"\nmy_age = 37###",
                    "#myName = \"Neo\"\n#my_age = 37"
                ),
                Questiontype.multipleChoice,
                1
            ),
            Question(
                5,
                "What is true?",
                listOf(
                    "Commenting your code helps explain your thought process and helps you and others to understand the intention of your code.",
                    "A comment in Python starts with the hash character, #, and extends to the end of the physical line.",
                    "Comments are non-executable statements in Python.",
                    "Python multi-line comment is a piece of text enclosed in a delimiter (“””) on each end of the comment"),
                listOf(),
                Questiontype.multipleChoice,
                1
            ),


        )
}

