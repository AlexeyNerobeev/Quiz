package com.example.quiz.feature_app.presentation.LeaderBoard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun LeaderBoardScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Text(text = "Список лидеров",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally))
            LazyColumn(modifier = Modifier
                .padding(top = 35.dp)
                .padding(horizontal = 25.dp)) {
                items(count = 10){
                    Box(modifier = Modifier
                        .padding(bottom = 20.dp)
                        .background(colorResource(R.color.TextFieldColor),
                            shape = RoundedCornerShape(20.dp)
                        )){
                        Row(modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(vertical = 16.dp)
                            .fillMaxWidth()) {
                            Box(modifier = Modifier
                                .size(24.dp)
                                .border(shape = CircleShape,
                                    width = 2.dp,
                                    color = colorResource(R.color.QuizGrayColor)),
                                contentAlignment = Alignment.Center){
                                Text(text = "1",
                                    color = colorResource(R.color.InsideColor),
                                    fontFamily = robotoRegular,
                                    fontSize = 14.sp
                                )
                            }

                        }
                    }
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomNavigation(navController, 4)
    }
}