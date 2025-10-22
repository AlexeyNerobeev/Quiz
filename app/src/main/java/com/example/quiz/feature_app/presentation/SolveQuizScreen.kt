package com.example.quiz.feature_app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import com.example.quiz.R
import com.example.quiz.common.robotoBlack
import com.example.quiz.common.robotoRegular
import kotlinx.serialization.json.Json

@Composable
fun SolveQuizScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = colorResource(R.color.QuizBackgroundColor))){
            Column(modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier
                        .size(60.dp, 22.dp)
                        .background(colorResource(R.color.QuizGrayColor),
                            shape = RoundedCornerShape(4.dp)
                        )){
                        Row(modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .padding(vertical = 4.dp)
                            .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(R.drawable.points_icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(14.dp))
                            Text(text = "200",
                                color = colorResource(R.color.PointsColor),
                                fontFamily = robotoBlack,
                                fontSize = 14.sp
                            )
                        }
                    }
                    Text(text = "Fantasy Quiz #156",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = robotoBlack
                    )
                    IconButton(onClick = {
                        navController.popBackStack()
                    },
                        modifier = Modifier
                            .size(36.dp)) {
                        Icon(painter = painterResource(R.drawable.close_quiz_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 28.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .height(12.dp)
                            .weight(1f)
                            .background(
                                color = colorResource(R.color.QuizGrayColor),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        color = colorResource(R.color.ProgressColor),
                        trackColor = colorResource(R.color.QuizGrayColor)
                    )
                    Text(text = "1/5",
                        color = colorResource(R.color.QuestionCountColor),
                        fontFamily = robotoRegular,
                        fontSize = 14.sp)
                }
            }
        }
    }
}