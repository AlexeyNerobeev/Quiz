package com.example.quiz.feature_app.presentation.AddQuiz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import com.example.quiz.feature_app.presentation.Profile.ProfileEvent
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
                    Text(text = "Количество вопросов:",
                        fontFamily = robotoRegular,
                        color = Color.Black,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionsCount,
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
                    Text(text = "Сложность:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                    Box(modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(color = colorResource(R.color.TextFieldColor),
                            shape = RoundedCornerShape(30.dp))
                        .clickable{
                            vm.onEvent(AddQuizEvent.DropMenu)
                        },
                        contentAlignment = Alignment.CenterStart){
                        Text(text = state.complexity,
                            color = Color.Black,
                            fontFamily = robotoRegular,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(start = 20.dp))
                        DropdownMenu(
                            expanded = state.expanded,
                            onDismissRequest = {
                                vm.onEvent(AddQuizEvent.DropMenu)
                            },
                            containerColor = colorResource(R.color.TextFieldColor)
                        ) {
                            Text(text = "Легко",
                                color = Color.Black,
                                fontFamily = robotoRegular,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clickable{
                                        vm.onEvent(AddQuizEvent.EnteredComplexity("Легко"))
                                    }
                            )
                            Text(text = "Средне",
                                color = Color.Black,
                                fontFamily = robotoRegular,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clickable{
                                        vm.onEvent(AddQuizEvent.EnteredComplexity("Средне"))
                                    }
                            )
                            Text(text = "Сложно",
                                color = Color.Black,
                                fontFamily = robotoRegular,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clickable{
                                        vm.onEvent(AddQuizEvent.EnteredComplexity("Сложно"))
                                    }
                            )
                        }
                    }
                    Text(text = "Название вопроса:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 40.dp))
                    OutlinedTextField(value = state.questionTitle,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredQuestionTitle(it))
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
                    Text(text = "Ответ 1:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionAnswer1,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredAnswer1(it))
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
                    Text(text = "Ответ 2:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionAnswer2,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredAnswer2(it))
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
                    Text(text = "Ответ 3:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionAnswer1,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredAnswer3(it))
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
                    Text(text = "Ответ 4:",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.questionAnswer4,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredAnswer1(it))
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
                    Text(text = "Номер правильного ответа(число):",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier
                            .padding(top = 10.dp))
                    OutlinedTextField(value = state.correctAnswer,
                        onValueChange = {
                            vm.onEvent(AddQuizEvent.EnteredCorrectAnswer(it))
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
                    Button(onClick = {

                    },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .background(colorResource(R.color.SignInButton),
                                shape = RoundedCornerShape(30.dp)),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Unspecified,
                            containerColor = colorResource(R.color.SignInButton)
                        ),
                        shape = RoundedCornerShape(30.dp)) {
                        Text("Сохранить вопрос",
                            color = colorResource(R.color.InsideColor),
                            fontFamily = robotoBlack,
                            fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier
                        .height(100.dp))
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