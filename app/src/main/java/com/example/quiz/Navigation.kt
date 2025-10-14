package com.example.quiz

sealed class NavRoutes(val route: String) {
    data object SignInScreen: NavRoutes("SignInScreen")
    data object SignUpScreen: NavRoutes("SignUpScreen")
    data object QuizListScreen: NavRoutes("QuizListScreen")
    data object SearchScreen: NavRoutes("SearchScreen")
    data object AddQuizScreen: NavRoutes("AddQuizScreen")
    data object ProfileScreen: NavRoutes("ProfileScreen")
}