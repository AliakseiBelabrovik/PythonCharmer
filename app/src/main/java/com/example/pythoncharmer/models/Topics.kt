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
    val description: String,
    val studyLinks: List<String>,
    val questions: @RawValue List<Question>,
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
            description = "Comments can be used to explain Python code."+"\n"+" Comments can be used to make the code more readable."
                    +" Comments can be used to prevent execution when testing code."
                    + "\n\n"
                    + "A block comment explains the code that follows it. Typically, you indent a block comment at the same level as the code block.\n"
                    + "To create a block comment, you start with a single hash sign (#) followed by a single space and a text string. "
                    + "\n\n"
                    + "A documentation string is a string literal that you put as the first lines in a code block, for example, a function."
                    + " Unlike a regular comment, a documentation string can be accessed at run-time using  obj.__doc__ attribute where obj is the name of the function."
                    + " Typically, you use a documentation string to automatically generate the code documentation."
                    + "\n\n"
                    + "In a similar way, we can use multiline strings (triple quotes) to write multiline comments."
                    + "The quotation character can either be ' or \"."
                    + "\n\n"
                    + "Python doesn't offer a separate way to write multiline comments. However, there are other ways to get around this issue. "
                    + "We can use # at the beginning of each line of comment on multiple lines."
                    + "\n\n"
                    + "How to Write Better Comments?"
                    + "\n\n"
                    + "Use comments to describe what a function does and not the specific details on how the function does it."
                    + " Try to remove as many redundant comments as possible. Try writing code that can explain itself, using better function/variable name choice."
                    + " Try to make the comments as short and concise as possible.",
            studyLinks =listOf("https://www.w3schools.com/python/python_comments.asp",
                               "https://www.pythontutorial.net/python-basics/python-comments/"),
            questions = listOf()
            ),
        Topic(
            id = 2,
            title = "Variables",
            complexityLevel = "easy",
            description = "A Python variable is a reserved memory location to store values. In other words, a variable in a python program gives data to the computer for processing.\n"
                    + "\n\n"
                    + "var1.4 is not valid because it contains a character which is not a letter, digit or underscore.\n"
                    + "return is not valid because it is a Python reserved word (keyword).\n"
                    + "2var is not valid because it begins with a digit.\n"
                    + "\n\n"
                    + "Variables need not be declared or defined in advance in Python. To create a variable, you just assign it a value."
                    + "\n\n"
                    + " A variable is a string of characters and numbers associated with a piece of information."
                    + " The assignment operator, denoted by the “=” symbol, is the operator that is used to assign values to variables in Python."
                    + " The line x=1 takes the known value, 1, and assigns that value to the variable with name “x”. After executing this line, this number will be stored into this variable."
                    + " Until the value is changed or the variable deleted, the character x behaves like the value 1."
                    + "\n\n"
                    + " Variables are not statically typed in Python, as they are in some other programming languages."
                    + "\n\n"
                    + "Use a lowercase single letter, word, or words. Separate words with underscores to improve readability."
                    + "\n\n",
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