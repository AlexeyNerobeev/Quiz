package com.example.quiz.feature_app.presentation.QuizList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.NavRoutes
import com.example.quiz.R
import com.example.quiz.common.BottomNavigation
import com.example.quiz.common.robotoBlack
import com.example.quiz.common.robotoRegular

@Composable
fun QuizListScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(R.drawable.back_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .clickable{
                            navController.popBackStack()
                        })
                Text(text = "Викторины",
                    fontFamily = robotoBlack,
                    fontSize = 20.sp,
                    color = colorResource(R.color.SignInButton)
                )
                IconButton(onClick = {
                    navController.navigate(NavRoutes.SearchScreen.route)
                },
                    modifier = Modifier
                        .size(22.dp)) {
                    Icon(painterResource(R.drawable.circle_search_icon),
                        contentDescription = null,
                        tint = Color.Unspecified)
                }
            }
            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            ) {

            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomNavigation(navController, 2)
    }
}