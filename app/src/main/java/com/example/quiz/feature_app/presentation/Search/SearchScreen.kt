package com.example.quiz.feature_app.presentation.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.common.BottomNavigation
import com.example.quiz.common.robotoBlack
import com.example.quiz.common.robotoRegular
import com.example.quiz.feature_app.presentation.Profile.ProfileEvent

@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .background(Color.Transparent)){
                    Icon(painter = painterResource(R.drawable.back_icon),
                        contentDescription = null,
                        tint = Color.Unspecified)
                }
                Text(
                    text = "Поиск",
                    fontFamily = robotoBlack,
                    fontSize = 20.sp,
                    color = colorResource(R.color.SignInButton)
                )
                Icon(
                    painterResource(R.drawable.back_icon),
                    contentDescription = null,
                    tint = Color.Transparent,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            OutlinedTextField(
                value = "",
                onValueChange = {

                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                    .background(color = Color.Transparent,
                        shape = RoundedCornerShape(30.dp))
                    .border(5.dp, color = colorResource(R.color.TextFieldColor)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colorResource(R.color.DarkColor),
                    unfocusedTextColor = colorResource(R.color.DarkColor),
                    focusedBorderColor = colorResource(R.color.TextFieldColor),
                    unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                textStyle = TextStyle(
                    fontFamily = robotoRegular,
                    fontSize = 16.sp,
                    color = colorResource(R.color.DarkColor)
                ),
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(painterResource(R.drawable.filter_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                },
                placeholder = {
                    Text(text = "Поиск",
                        color = colorResource(R.color.DarkColor),
                        fontFamily = robotoRegular,
                        fontSize = 16.sp)
                }
            )
            Column(modifier = Modifier
                .padding(top = 45.dp)
                .padding(horizontal = 35.dp)) {
                Text(text = "Часто ищут",
                color = colorResource(R.color.InsideColor),
                    fontFamily = robotoBlack,
                    fontSize = 20.sp)
                LazyColumn(modifier = Modifier
                    .padding(top = 21.dp)) {
                    items(10){
                        Box(modifier = Modifier
                            .padding(bottom = 11.dp)
                            .fillMaxWidth()
                            .height(52.dp)
                            .background(color = colorResource(R.color.TextFieldColor),
                                shape = RoundedCornerShape(30.dp))){
                            Row(modifier = Modifier
                                .align(Alignment.CenterStart),
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painterResource(R.drawable.circle_search_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .size(31.dp)
                                        .padding(start = 14.dp)
                                )
                                Text(
                                    text = "Викторина",
                                    fontFamily = robotoRegular,
                                    fontSize = 15.sp,
                                    color = colorResource(R.color.DarkColor),
                                    modifier = Modifier
                                        .padding(start = 24.dp)
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
        BottomNavigation(navController, 3)
    }
}