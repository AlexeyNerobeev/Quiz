package com.example.quiz.feature_app.presentation.Profile

sealed class ProfileEvent {
    data class EnteredName(val value: String): ProfileEvent()
    data class EnteredEmail(val value: String): ProfileEvent()
}