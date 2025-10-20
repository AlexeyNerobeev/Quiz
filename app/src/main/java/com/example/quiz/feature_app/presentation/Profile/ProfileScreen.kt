package com.example.quiz.feature_app.presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.quiz.NavRoutes
import com.example.quiz.R
import com.example.quiz.common.BottomNavigation
import com.example.quiz.common.robotoBlack
import com.example.quiz.common.robotoRegular
import com.example.quiz.feature_app.presentation.AddQuiz.AddQuizEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(navController: NavController, vm: ProfileVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = null) {
        vm.onEvent(ProfileEvent.GetProfile)
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
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
                    text = "Профиль",
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
            Box(modifier = Modifier
                .padding(top = 27.dp)
                .size(148.dp)
                .align(Alignment.CenterHorizontally)){
                Image(painter = painterResource(R.drawable.profile_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(148.dp))
                IconButton(onClick = {

                },
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 10.dp)) {
                    Icon(painterResource(R.drawable.cam_icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(35.dp))
                }
            }
            Box(modifier = Modifier
                .padding(top = 23.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(colorResource(R.color.IconSquareColor)),
                contentAlignment = Alignment.Center){
                Column {
                    Text(text = "User Name",
                        fontFamily = robotoBlack,
                        fontSize = 20.sp,
                        color = colorResource(R.color.DarkColor))
                }
            }
            Column(modifier = Modifier
                .padding(top = 35.dp)
                .padding(horizontal = 35.dp)) {
                Text(
                    text = "Имя",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = robotoRegular
                )
                OutlinedTextField(
                    value = state.name,
                    onValueChange = {
                        vm.onEvent(ProfileEvent.EnteredName(it))
                    },
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedBorderColor = colorResource(R.color.TextFieldColor),
                        unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                        focusedContainerColor = colorResource(R.color.TextFieldColor),
                        unfocusedContainerColor = colorResource(R.color.TextFieldColor)
                    ),
                    textStyle = TextStyle(
                        fontFamily = robotoRegular,
                        fontSize = 16.sp,
                        color = colorResource(R.color.DarkColor)
                    ),
                    singleLine = true
                )
                Text(
                    text = "Почта",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = robotoRegular,
                    modifier = Modifier
                        .padding(top = 14.dp)
                )
                OutlinedTextField(
                    value = state.email,
                    onValueChange = {
                        vm.onEvent(ProfileEvent.EnteredEmail(it))
                    },
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedBorderColor = colorResource(R.color.TextFieldColor),
                        unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                        focusedContainerColor = colorResource(R.color.TextFieldColor),
                        unfocusedContainerColor = colorResource(R.color.TextFieldColor)
                    ),
                    textStyle = TextStyle(
                        fontFamily = robotoRegular,
                        fontSize = 16.sp,
                        color = colorResource(R.color.DarkColor)
                    ),
                    singleLine = true
                )
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(R.color.SignInButton),
                            shape = RoundedCornerShape(30.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Unspecified,
                        containerColor = colorResource(R.color.SignInButton)
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(
                        text = "Обновить профиль",
                        color = colorResource(R.color.InsideColor),
                        fontFamily = robotoBlack,
                        fontSize = 20.sp
                    )
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