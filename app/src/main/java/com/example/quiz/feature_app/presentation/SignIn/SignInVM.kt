package com.example.quiz.feature_app.presentation.SignIn

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.feature_app.domain.usecase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInVM(
    private val signInUseCase: SignUpUseCase
): ViewModel() {
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
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        signInUseCase.invoke(email = state.value.email,
                            password = state.value.password)
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        Log.e("supabase", ex.message.toString())
                    }
                }
            }
            is SignInEvent.VisualTransformation -> {
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
        }
    }
}