package com.example.quiz.feature_app.presentation.Profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.feature_app.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileVM(
    private val getProfileUseCase: GetProfileUseCase
): ViewModel() {
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
            is ProfileEvent.GetProfile -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val profile = getProfileUseCase.invoke()
                        _state.value = state.value.copy(
                            name = profile.name,
                            email = profile.email
                        )
                    } catch (ex: Exception){
                        Log.e("supabase", ex.message.toString())
                    }
                }
            }
        }
    }
}