package com.example.quiz.feature_app.presentation.SignIn

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isComplete: Boolean = false,
    val error: String = "",
    val visual: Boolean = true
)