package com.example.quiz.feature_app.domain.usecase

import com.example.quiz.feature_app.domain.repository.AuthRepository

class SignInUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String){
        authRepository.signIn(email, password)
    }
}