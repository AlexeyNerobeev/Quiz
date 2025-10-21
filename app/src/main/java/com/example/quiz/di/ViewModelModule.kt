package com.example.quiz.di

import com.example.quiz.feature_app.presentation.AddQuiz.AddQuizVM
import com.example.quiz.feature_app.presentation.Profile.ProfileVM
import com.example.quiz.feature_app.presentation.SignIn.SignInVM
import com.example.quiz.feature_app.presentation.SignUp.SignUpVM
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleVM = module {
    viewModel<SignInVM> {
        SignInVM(get())
    }
    viewModel<SignUpVM> {
        SignUpVM(get())
    }
    viewModel<AddQuizVM> {
        AddQuizVM()
    }
    viewModel<ProfileVM> {
        ProfileVM(get(), get())
    }
}