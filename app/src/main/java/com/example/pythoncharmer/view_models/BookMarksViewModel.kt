package com.example.pythoncharmer.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pythoncharmer.models.Topic

class BookMarksViewModel : ViewModel() {

    private val _bookMarkedTopics = mutableStateListOf<Topic>() // mutableListOf<Movie>()
    val bookMarkedTopic: List<Topic>
        get() = _bookMarkedTopics


    fun addToBookMarks(topic: Topic) {
        if(!exists(topic = topic)){
            _bookMarkedTopics.add(topic)
        }
    }

    fun removeFromBookMarks(topic: Topic){
        _bookMarkedTopics.remove(topic)
    }

    private fun exists(topic: Topic) : Boolean {
        return _bookMarkedTopics.any {m -> m.id == topic.id }
    }

    fun isFavorite(topic: Topic) : Boolean {
        return exists(topic)
    }
}



