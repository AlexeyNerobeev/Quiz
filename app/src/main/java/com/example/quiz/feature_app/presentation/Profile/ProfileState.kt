package com.example.quiz.feature_app.presentation.Profile

data class ProfileState(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val isUpdate: Boolean = false
)
