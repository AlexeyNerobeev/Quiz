package com.example.quiz.feature_app.presentation.SignUp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.feature_app.domain.usecase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpVM(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent){
        when(event){
            is SignUpEvent.EnteredName ->{
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is SignUpEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is SignUpEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is SignUpEvent.NextPage -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        signUpUseCase.invoke(email = state.value.email, password = state.value.password, name = state.value.name)
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        Log.e("supabase", ex.message.toString())
                    }
                }
            }
            is SignUpEvent.VisualTransformation -> {
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
        }
    }
}