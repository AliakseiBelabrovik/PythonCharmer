package com.example.pythoncharmer.widgets

import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

//is a flag that indicates what side of the card to show
//swap the content at 90 degree
enum class CardFace( val angle : Float) {
    Front(0f) {
        override val next : CardFace
            get() = Back
    },

    Back(180f) {
        override val next : CardFace
            get() = Front
    };

    abstract val next : CardFace
}

