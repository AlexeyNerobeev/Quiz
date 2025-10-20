package com.example.quiz.di

import com.example.quiz.feature_app.data.repositoryImplementation.ProfileRepositoryImpl
import com.example.quiz.feature_app.domain.repository.ProfileRepository
import com.example.quiz.feature_app.domain.usecase.GetProfileUseCase
import org.koin.dsl.module

val moduleProfile = module{
    single<ProfileRepository> {
        ProfileRepositoryImpl()
    }
    factory<GetProfileUseCase> {
        GetProfileUseCase(get())
    }
}