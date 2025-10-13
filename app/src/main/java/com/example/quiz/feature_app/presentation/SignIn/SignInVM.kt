package com.example.quiz.feature_app.presentation.SignIn

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInVM: ViewModel() {
    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInEvent){
        when(event){
            is SignInEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is SignInEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is SignInEvent.NextPage -> {
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
            is SignInEvent.VisualTransformation -> {
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
        }
    }
}