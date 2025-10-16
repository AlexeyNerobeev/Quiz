package com.example.quiz.feature_app.data.repositoryImplementation

import com.example.quiz.feature_app.data.supabase.Connect.supabase
import com.example.quiz.feature_app.domain.models.Quiz
import com.example.quiz.feature_app.domain.repository.QuizRepository
import io.github.jan.supabase.auth.auth

class QuizRepositoryImpl: QuizRepository {
    override suspend fun createQuiz(title: String, complexity: String, questionsCount: Int) {
        
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id ?: ""
    }
}