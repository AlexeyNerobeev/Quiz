package com.example.quiz.feature_app.presentation.SignIn

sealed class SignInEvent {
    data class EnteredEmail(val value: String): SignInEvent()
    data class EnteredPassword(val value: String): SignInEvent()
    data object VisualTransformation: SignInEvent()
    data object NextPage: SignInEvent()
}