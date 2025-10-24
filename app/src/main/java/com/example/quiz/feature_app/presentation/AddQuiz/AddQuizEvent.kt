package com.example.quiz.feature_app.presentation.AddQuiz

sealed class AddQuizEvent {
    data class EnteredQuizTitle(val value: String): AddQuizEvent()
    data class EnteredComplexity(val value: String): AddQuizEvent()
    data class EnteredQuestionsCount(val value: String): AddQuizEvent()
    data class EnteredQuestionTitle(val value: String): AddQuizEvent()
    data class EnteredAnswer1(val value: String): AddQuizEvent()
    data class EnteredAnswer2(val value: String): AddQuizEvent()
    data class EnteredAnswer3(val value: String): AddQuizEvent()
    data class EnteredAnswer4(val value: String): AddQuizEvent()
    data class EnteredCorrectAnswer(val value: String): AddQuizEvent()
    data object NextQuestion: AddQuizEvent()
    data object SaveQuiz: AddQuizEvent()
    data object CreateQuiz: AddQuizEvent()
    data object DropMenu: AddQuizEvent()
}