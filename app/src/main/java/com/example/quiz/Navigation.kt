package com.example.quiz

sealed class NavRoutes(val route: String) {
    data object SignInScreen: NavRoutes("SignInScreen")
    data object SignUpScreen: NavRoutes("SignUpScreen")
    data object QuizListScreen: NavRoutes("QuizListScreen")
}