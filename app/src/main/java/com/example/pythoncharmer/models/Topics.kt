package com.example.pythoncharmer.models

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable

import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic (
    val id : Int,
    val title: String,
    val complexityLevel: String,
    //val precedingTopic: String,
    //val followingTopic: String,
    val studyLinks: List<String>,
    val multipleChoiceQuestions: List<String>,
    val singleChoiceQuestions: List<String>
    ) : Parcelable {
    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
    }

class TopicType : NavType<Topic>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): Topic? {
        return bundle.getParcelable( key )
    }

    override fun parseValue(value: String): Topic {
        return Gson().fromJson( value, Topic::class.java )
    }

    override fun put(bundle: Bundle, key: String, value: Topic) {
        bundle.putParcelable( key, value )
    }

}

fun getTopics() : List<Topic> {
    return listOf(
        Topic(
            id = 1,
            title = "Comments",
            complexityLevel = "easy",
            studyLinks =listOf("https://www.w3schools.com/python/python_comments.asp",
                               "https://www.pythontutorial.net/python-basics/python-comments/"),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
            ),
        Topic(
            id = 2,
            title = "Variables",
            complexityLevel = "easy",
            studyLinks =listOf("https://www.w3schools.com/python/python_variables.asp",
                               "https://www.pythontutorial.net/python-basics/python-variables/"),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),Topic(
            id = 3,
            title = "Data types",
            complexityLevel = "easy",
            studyLinks =listOf("https://www.w3schools.com/python/python_datatypes.asp",
                               "https://realpython.com/python-data-types/"),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 4,
            title = "Numbers",
            complexityLevel = "easy",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 5,
            title = "Strings",
            complexityLevel = "easy",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 6,
            title = "Operators",
            complexityLevel = "easy",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 7,
            title = "Lists",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 8,
            title = "Dictionaries",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 9,
            title = "If...else",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 10,
            title = "While & For Loops",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 11,
            title = "Functions",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 12,
            title = "Lambda functions",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 13,
            title = "Arrays",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 14,
            title = "Objects",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        ),
        Topic(
            id = 15,
            title = "Inheritance",
            complexityLevel = "medium",
            studyLinks =listOf(),
            multipleChoiceQuestions = listOf(),
            singleChoiceQuestions = listOf()
        )
    )
}