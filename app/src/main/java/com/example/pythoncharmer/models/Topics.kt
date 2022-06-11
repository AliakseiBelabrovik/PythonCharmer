package com.example.pythoncharmer.models

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable

import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class Topic (
    val id : Int,
    val title: String,
    val complexityLevel: String,
    //val precedingTopic: String,
    //val followingTopic: String,
    val description: String,
    val studyLinks: List<String>,
    val questions: @RawValue List<Question>,
    //val singleChoiceQuestions: List<String>
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
            description = "Comments can be used to explain Python code.\n" +
                    "\n" +
                    "Comments can be used to make the code more readable.\n" +
                    "\n" +
                    "Comments can be used to prevent execution when testing code.",
            studyLinks =listOf("https://www.w3schools.com/python/python_comments.asp",
                               "https://www.pythontutorial.net/python-basics/python-comments/"),
            questions = listOf()
            ),
        Topic(
            id = 2,
            title = "Variables",
            complexityLevel = "easy",
            description = "A Python variable is a reserved memory location to store values. In other words, a variable in a python program gives data to the computer for processing.\n",
            studyLinks =listOf("https://www.w3schools.com/python/python_variables.asp",
                               "https://www.pythontutorial.net/python-basics/python-variables/"),
            questions = listOf(),

        ),Topic(
            id = 3,
            title = "Data types",
            complexityLevel = "easy",
            description = "Data types are the classification or categorization of data items. It represents the kind of value that tells what operations can be performed on a particular data. Since everything is an object in Python programming, data types are actually classes and variables are instance (object) of these classes.\n" +
                    "\n",
            studyLinks =listOf("https://www.w3schools.com/python/python_datatypes.asp",
                               "https://realpython.com/python-data-types/"),
            questions = listOf(),
        ),
        Topic(
            id = 4,
            title = "Numbers",
            complexityLevel = "easy",
            description = "N",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 5,
            title = "Strings",
            complexityLevel = "easy",
            description = "S",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 6,
            title = "Operators",
            complexityLevel = "easy",
            description = "O",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 7,
            title = "Lists",
            complexityLevel = "medium",
            description = "L",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 8,
            title = "Dictionaries",
            complexityLevel = "medium",
            description = "D",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 9,
            title = "If...else",
            complexityLevel = "medium",
            description = "I",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 10,
            title = "While & For Loops",
            complexityLevel = "medium",
            description = "W",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 11,
            title = "Functions",
            complexityLevel = "medium",
            description = "F",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 12,
            title = "Lambda functions",
            complexityLevel = "medium",
            description = "L",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 13,
            title = "Arrays",
            complexityLevel = "medium",
            description = "A",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 14,
            title = "Objects",
            complexityLevel = "medium",
            description = "O",
            studyLinks =listOf(),
            questions = listOf(),
        ),
        Topic(
            id = 15,
            title = "Inheritance",
            complexityLevel = "medium",
            description = "I",
            studyLinks =listOf(),
            questions = listOf(),
        )
    )
}