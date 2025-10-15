package com.example.quiz.feature_app.presentation.AddQuiz

data class AddQuizState(
    val complexity: String = "",
    val questionsCount: String = "",
    val title: String = "",
    val questionTitle: String = "",
    val questionAnswer1: String = "",
    val questionAnswer2: String = "",
    val questionAnswer3: String = "",
    val questionAnswer4: String = "",
    val correctAnswer: String = "",
    val isComplete: Boolean = false
)
