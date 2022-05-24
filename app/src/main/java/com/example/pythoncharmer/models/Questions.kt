package com.example.pythoncharmer.models


data class Questions(
    val id: Int,
    val question: String,
    val correctAnswer: List<String>,
    val wrongAnswer: List<String>,
    val questionType: Questiontype,
    val topic: Int
) {

}

fun getQuestions() : List<Questions> {
        return listOf(
            Questions(
              1,
              "testfrage",
              listOf("ist richtig"),
              listOf("falsch","auch falsch","auchfalsch"),
                Questiontype.singeleChoice,
                1
            ),
            Questions(
                2,
                "testfrage2",
                listOf("ist richtig","auchRichtig"),
                listOf("falsch","auch falsch"),
                Questiontype.multipleChoice,
                1
            ),
            Questions(
                3,
                "testfrage3",
                listOf("ist richtig","auchRichtig","nohcmal Richtig"),
                listOf("falsch"),
                Questiontype.multipleChoice,
                1
            ),
            Questions(
                4,
                "testfrage4",
                listOf("ist richtig"),
                listOf("falsch","auch falsch","und nochmal falsch"),
                Questiontype.multipleChoice,
                1
            ),
            Questions(
                5,
                "testfrage5",
                listOf("ist richtig","auchRichtig","ist richtig","auchRichtig"),
                listOf(),
                Questiontype.multipleChoice,
                1
            ),


        )
}

