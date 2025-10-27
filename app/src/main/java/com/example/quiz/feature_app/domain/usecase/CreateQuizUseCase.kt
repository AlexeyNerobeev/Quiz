package com.example.quiz.feature_app.domain.usecase

import com.example.quiz.feature_app.domain.repository.QuizRepository

class CreateQuizUseCase(private val quizRepository: QuizRepository) {
    suspend operator fun invoke(title: String, complexity: String, questionsCount: Int): Int{
        return quizRepository.createQuiz(title = title, complexity = complexity, questionsCount = questionsCount)
    }
}