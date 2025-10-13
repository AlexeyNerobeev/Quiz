package com.example.quiz.di

import com.example.quiz.feature_app.data.repositoryImplementation.AuthRepositoryImpl
import com.example.quiz.feature_app.domain.repository.AuthRepository
import com.example.quiz.feature_app.domain.usecase.SignInUseCase
import com.example.quiz.feature_app.domain.usecase.SignUpUseCase
import org.koin.dsl.module

val moduleAuth = module {
    single<AuthRepository>{
        AuthRepositoryImpl()
    }
    factory<SignUpUseCase> {
        SignUpUseCase(get())
    }
    factory<SignInUseCase> {
        SignInUseCase(get())
    }
}