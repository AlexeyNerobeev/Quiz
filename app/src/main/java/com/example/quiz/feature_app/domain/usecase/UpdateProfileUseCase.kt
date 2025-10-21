package com.example.quiz.feature_app.domain.usecase

import com.example.quiz.feature_app.domain.repository.ProfileRepository

class UpdateProfileUseCase(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(id: Int, name: String, email: String){
        profileRepository.updateProfile(id = id, name = name, email = email)
    }
}