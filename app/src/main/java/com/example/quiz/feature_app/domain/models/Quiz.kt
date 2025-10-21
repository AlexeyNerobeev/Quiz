package com.example.quiz.feature_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(
    val id: Int = 0,
    val author_id: Int = 0,
    val questions_count: Int = 0,
    val complexity: String = "",
    val title: String = ""
)
