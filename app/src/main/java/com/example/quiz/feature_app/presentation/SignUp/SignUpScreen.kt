package com.example.quiz.feature_app.presentation.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.NavRoutes
import com.example.quiz.R
import com.example.quiz.common.leagueSpartanLight
import com.example.quiz.common.poppinsMedium
import com.example.quiz.common.poppinsRegular
import com.example.quiz.common.poppinsSemiBold
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(navController: NavController, vm: SignUpVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.QuizListScreen.route)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 32.dp)) {
            Text(text = "Регистрация",
                color = colorResource(R.color.TitleText),
                fontSize = 20.sp,
                fontFamily = poppinsSemiBold,
                modifier = Modifier
                    .padding(top = 36.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = "Имя",
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = poppinsMedium,
                modifier = Modifier
                    .padding(top = 120.dp))
            OutlinedTextField(value = state.name,
                onValueChange = {
                    vm.onEvent(SignUpEvent.EnteredName(it))
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = colorResource(R.color.TextFieldColor),
                    unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                    focusedContainerColor = colorResource(R.color.TextFieldColor),
                    unfocusedContainerColor = colorResource(R.color.TextFieldColor)
                ),
                textStyle = TextStyle(
                    fontFamily = poppinsRegular,
                    fontSize = 16.sp
                ),
                singleLine = true
            )
            Text(text = "Почта",
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = poppinsMedium,
                modifier = Modifier
                    .padding(top = 23.dp))
            OutlinedTextField(value = state.email,
                onValueChange = {
                    vm.onEvent(SignUpEvent.EnteredEmail(it))
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = colorResource(R.color.TextFieldColor),
                    unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                    focusedContainerColor = colorResource(R.color.TextFieldColor),
                    unfocusedContainerColor = colorResource(R.color.TextFieldColor)
                ),
                textStyle = TextStyle(
                    fontFamily = poppinsRegular,
                    fontSize = 16.sp
                ),
                singleLine = true
            )
            Text(text = "Пароль",
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = poppinsMedium,
                modifier = Modifier
                    .padding(top = 23.dp))
            OutlinedTextField(value = state.password,
                onValueChange = {
                    vm.onEvent(SignUpEvent.EnteredPassword(it))
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = colorResource(R.color.TextFieldColor),
                    unfocusedBorderColor = colorResource(R.color.TextFieldColor),
                    focusedContainerColor = colorResource(R.color.TextFieldColor),
                    unfocusedContainerColor = colorResource(R.color.TextFieldColor)
                ),
                textStyle = TextStyle(
                    fontFamily = poppinsRegular,
                    fontSize = 16.sp
                ),
                singleLine = true,
                visualTransformation =
                    if(state.visual){
                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    },
                trailingIcon = {
                    Icon(painter = painterResource(R.drawable.eye_icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .clickable{vm.onEvent(SignUpEvent.VisualTransformation)})
                }
            )
            Button(onClick = {
                vm.onEvent(SignUpEvent.NextPage)
            },
                modifier = Modifier
                    .padding(top = 70.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(color = colorResource(R.color.SignInButton),
                        RoundedCornerShape(30.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.SignInButton),
                    contentColor = Color.Unspecified
                )
            ) {
                Text("Зарегистрироваться",
                    fontFamily = poppinsSemiBold,
                    fontSize = 20.sp,
                    color = colorResource(R.color.InsideColor))
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Row(modifier = Modifier
                .padding(bottom = 59.dp)){
                Text(text = "Уже есть аккаунт? ",
                    fontFamily = leagueSpartanLight,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Text(text = "Войти",
                    fontFamily = leagueSpartanLight,
                    fontSize = 13.sp,
                    color = colorResource(R.color.InsideColor),
                    modifier = Modifier
                        .clickable{
                            navController.navigate(NavRoutes.SignInScreen.route)
                        })
            }
        }
    }
}