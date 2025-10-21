package com.example.quiz.feature_app.domain.repository

import com.example.quiz.feature_app.domain.models.Profile

interface ProfileRepository {
    suspend fun getProfile(): Profile
    suspend fun updateProfile(id: Int, name: String, email: String)
}