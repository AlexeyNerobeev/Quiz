package com.example.quiz.feature_app.presentation.SignUp

data class SignUpState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isComplete: Boolean = false,
    val error: String = "",
    val visual: Boolean = true
)
