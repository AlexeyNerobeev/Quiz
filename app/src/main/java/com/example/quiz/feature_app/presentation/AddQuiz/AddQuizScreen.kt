package com.example.quiz.feature_app.presentation.AddQuiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.common.BottomNavigation
import com.example.quiz.common.poppinsRegular
import com.example.quiz.common.robotoBlack
import com.example.quiz.common.robotoRegular
import com.example.quiz.feature_app.presentation.SignIn.SignInEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddQuizScreen(navController: NavController, vm: AddQuizVM = koinViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Text(text = "Создание викторины",
                color = colorResource(R.color.SignInButton),
                fontFamily = robotoBlack,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            LazyColumn(modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 24.dp)) {
                item {
                    Text(text = "Название викторины:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular
                    )
                    OutlinedTextField(value = state.title,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredQuizTitle(it))
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
                            fontFamily = robotoRegular,
                            fontSize = 16.sp
                        ),
                        singleLine = true
                    )
                    Text(text = "Сложность:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                    OutlinedTextField(value = state.complexity,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredComplexity(it))
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
                            fontFamily = robotoRegular,
                            fontSize = 16.sp
                        ),
                        singleLine = true
                    )
                    Text(text = "Количество вопросов:",
                        fontFamily = robotoRegular,
                        color = Color.Black,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionsCount.toString(),
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredQuestionsCount(it))
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
                            fontFamily = robotoRegular,
                            fontSize = 16.sp
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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
        BottomNavigation(navController, 1)
    }
}