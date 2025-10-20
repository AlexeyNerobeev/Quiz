package com.example.quiz.feature_app.data.repositoryImplementation

import com.example.quiz.feature_app.data.supabase.Connect.supabase
import com.example.quiz.feature_app.domain.models.Profile
import com.example.quiz.feature_app.domain.repository.ProfileRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getProfile(): Profile {
        return supabase.postgrest["profile"].select(
            columns = Columns.list(
                "name",
                "email"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id ?: ""
    }
}