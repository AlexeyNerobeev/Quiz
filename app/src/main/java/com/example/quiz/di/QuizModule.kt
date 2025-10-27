package com.example.quiz.di

import com.example.quiz.feature_app.data.repositoryImplementation.QuizRepositoryImpl
import com.example.quiz.feature_app.domain.repository.QuizRepository
import com.example.quiz.feature_app.domain.usecase.CreateQuizUseCase
import org.koin.dsl.module

val moduleQuiz = module {
    single<QuizRepository> {
        QuizRepositoryImpl()
    }
    factory<CreateQuizUseCase> {
        CreateQuizUseCase(get())
    }
}