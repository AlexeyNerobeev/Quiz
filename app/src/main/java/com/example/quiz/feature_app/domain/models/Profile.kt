package com.example.quiz.feature_app.domain.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class Profile(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val user_id: String = ""
)
