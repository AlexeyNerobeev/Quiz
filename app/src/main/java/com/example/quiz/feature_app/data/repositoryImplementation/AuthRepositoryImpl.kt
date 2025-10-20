package com.example.quiz.feature_app.data.repositoryImplementation

import com.example.quiz.feature_app.data.supabase.Connect.supabase
import com.example.quiz.feature_app.domain.models.Profile
import com.example.quiz.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class AuthRepositoryImpl: AuthRepository {
    override suspend fun signIn(inputEmail: String, inputPassword: String) {
        supabase.auth.signInWith(Email){
            email = inputEmail
            password = inputPassword

        }
    }

    override suspend fun signUp(inputEmail: String, inputPassword: String, inputName: String) {
        supabase.auth.signUpWith(Email){
            email = inputEmail
            password = inputPassword
        }
        val profile = Profile(name = inputName, email = inputEmail, user_id = getUserId())
        supabase.postgrest["profile"].insert(profile)
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id ?: ""
    }
}