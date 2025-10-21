package com.example.quiz

import android.app.Application
import com.example.quiz.di.moduleAuth
import com.example.quiz.di.moduleProfile
import com.example.quiz.di.moduleVM
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            androidLogger(level = Level.DEBUG)
            modules(
                moduleVM, moduleAuth, moduleProfile
            )
        }
    }
}