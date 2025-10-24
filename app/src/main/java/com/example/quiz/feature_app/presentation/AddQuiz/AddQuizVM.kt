package com.example.quiz.feature_app.presentation.AddQuiz

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddQuizVM: ViewModel() {
    private val _state = mutableStateOf(AddQuizState())
    val state: State<AddQuizState> = _state

    fun onEvent(event: AddQuizEvent){
        when(event){
            is AddQuizEvent.EnteredQuizTitle -> {
                _state.value = state.value.copy(
                    title = event.value
                )
            }
            is AddQuizEvent.EnteredQuestionsCount -> {
                _state.value = state.value.copy(
                    questionsCount = event.value
                )
                try {
                    val questionsCount = mutableIntStateOf(state.value.questionsCount.toInt())
                } catch (ex: Exception){
                    Log.e("toInt", ex.message.toString())
                }
            }
            is AddQuizEvent.EnteredComplexity -> {
                _state.value = state.value.copy(
                    complexity = event.value
                )
            }
            is AddQuizEvent.EnteredQuestionTitle -> {
                _state.value = state.value.copy(
                    questionTitle = event.value
                )
            }
            is AddQuizEvent.EnteredAnswer1 -> {
                _state.value = state.value.copy(
                    questionAnswer1 = event.value
                )
            }
            is AddQuizEvent.EnteredAnswer2 -> {
                _state.value = state.value.copy(
                    questionAnswer2 = event.value
                )
            }
            is AddQuizEvent.EnteredAnswer3 -> {
                _state.value = state.value.copy(
                    questionAnswer3 = event.value
                )
            }
            is AddQuizEvent.EnteredAnswer4 -> {
                _state.value = state.value.copy(
                    questionAnswer4 = event.value
                )
            }
            is AddQuizEvent.EnteredCorrectAnswer -> {
                _state.value = state.value.copy(
                    correctAnswer = event.value
                )
                try {
                    val correctAnswer = mutableIntStateOf(state.value.questionsCount.toInt())
                } catch (ex: Exception){
                    Log.e("toInt", ex.message.toString())
                }
            }
            is AddQuizEvent.NextQuestion -> {
                _state.value = state.value.copy(
                    questionAnswer1 = "",
                    questionAnswer2 = "",
                    questionAnswer3 = "",
                    questionAnswer4 = "",
                    correctAnswer = ""
                )
            }
            is AddQuizEvent.SaveQuiz -> {

            }
            is AddQuizEvent.CreateQuiz -> {

            }
            is AddQuizEvent.DropMenu -> {
                _state.value = state.value.copy(
                    expanded = !state.value.expanded
                )
            }
        }
    }
}