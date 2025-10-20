package com.example.quiz.feature_app.domain.usecase

import com.example.quiz.feature_app.domain.models.Profile
import com.example.quiz.feature_app.domain.repository.ProfileRepository

class GetProfileUseCase(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(): Profile {
        return profileRepository.getProfile()
    }
}