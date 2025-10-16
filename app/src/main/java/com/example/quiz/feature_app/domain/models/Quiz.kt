package com.example.quiz.feature_app.domain.models

data class Quiz(
    val id: Int = 0,
    val author_id: Int = 0,
    val questions_count: Int = 0,
    val complexity: String = "",
    val title: String = ""
)
