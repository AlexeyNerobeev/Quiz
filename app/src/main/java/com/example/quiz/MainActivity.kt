package com.example.quiz

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.feature_app.presentation.AddQuiz.AddQuizScreen
import com.example.quiz.feature_app.presentation.Profile.ProfileScreen
import com.example.quiz.feature_app.presentation.QuizList.QuizListScreen
import com.example.quiz.feature_app.presentation.Search.SearchScreen
import com.example.quiz.feature_app.presentation.SignIn.SignInScreen
import com.example.quiz.feature_app.presentation.SignUp.SignUpScreen
import com.example.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavRoutes.ProfileScreen.route){
                composable(NavRoutes.SignInScreen.route) { SignInScreen(navController) }
                composable(NavRoutes.SignUpScreen.route) { SignUpScreen(navController)}
                composable(NavRoutes.QuizListScreen.route) { QuizListScreen(navController) }
                composable(NavRoutes.SearchScreen.route) { SearchScreen(navController) }
                composable(NavRoutes.AddQuizScreen.route) { AddQuizScreen(navController) }
                composable(NavRoutes.ProfileScreen.route) { ProfileScreen(navController) }
            }
        }
    }
}