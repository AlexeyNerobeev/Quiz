package com.example.quiz.feature_app.domain.repository

interface QuizRepository {
    suspend fun createQuiz(title: String, complexity: String, questionsCount: Int)
}