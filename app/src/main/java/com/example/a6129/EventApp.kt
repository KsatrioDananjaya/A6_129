package com.example.a6129

import android.app.Application
import com.example.a6129.dependenciesinjection.AppContainer
import com.example.a6129.dependenciesinjection.ContainerApp

class AcaraApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = ContainerApp()
    }
}