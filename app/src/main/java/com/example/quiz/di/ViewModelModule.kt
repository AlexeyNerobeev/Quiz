package com.example.quiz.di

import com.example.quiz.feature_app.presentation.SignIn.SignInVM
import com.example.quiz.feature_app.presentation.SignUp.SignUpVM
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleVM = module {
    viewModel<SignInVM> {
        SignInVM()
    }
    viewModel<SignUpVM> {
        SignUpVM()
    }
}