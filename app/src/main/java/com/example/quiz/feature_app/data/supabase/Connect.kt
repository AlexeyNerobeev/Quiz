package com.example.quiz.feature_app.data.supabase

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://zhjhfszvchqbhdhkxfwv.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inpoamhmc3p2Y2hxYmhkaGt4Znd2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjAyOTI0NDIsImV4cCI6MjA3NTg2ODQ0Mn0.1RMoK_vK0c_E7CAS8TdFeUdUbuNMMl18oE_F6x4jTx0"
    ){
        install(Auth)
        install(Postgrest)
    }
}