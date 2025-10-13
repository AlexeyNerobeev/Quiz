package com.example.quiz.feature_app.presentation.SignUp


sealed class SignUpEvent {
    data class EnteredName(val value: String): SignUpEvent()
    data class EnteredEmail(val value: String): SignUpEvent()
    data class EnteredPassword(val value: String): SignUpEvent()
    data object VisualTransformation: SignUpEvent()
    data object NextPage: SignUpEvent()
}