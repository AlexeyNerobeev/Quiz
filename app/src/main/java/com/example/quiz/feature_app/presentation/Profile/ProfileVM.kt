package com.example.quiz.feature_app.presentation.Profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileVM: ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    fun onEvent(event: ProfileEvent){
        when(event){
            is ProfileEvent.EnteredName -> {
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is ProfileEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
        }
    }
}