package com.example.quiz.feature_app.data.repositoryImplementation

import com.example.quiz.feature_app.data.supabase.Connect.supabase
import com.example.quiz.feature_app.domain.models.Quiz
import com.example.quiz.feature_app.domain.repository.QuizRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class QuizRepositoryImpl: QuizRepository {
    override suspend fun createQuiz(title: String, complexity: String, questionsCount: Int): Int {
        val quiz = Quiz(author_id = getUserId(), title = title, complexity = complexity, questions_count = questionsCount)
        val returnQuizId = supabase.postgrest["quiz"].insert(quiz){
            select(columns = Columns.list(
                "id"
            ))
        }.decodeSingle<Quiz>()
        return returnQuizId.id
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id ?: ""
    }
}