package com.example.quiz.feature_app.domain.models

data class Profile(
    val id: Int,
    val name: String = "",
    val email: String = "",
    val user_id: String = ""
)
