package com.example.scootboost.data.di

import android.app.Application
import android.content.Context
import androidx.credentials.CredentialManager
import com.example.scootboost.data.android.DispatchApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@HiltAndroidApp
class App :Application()

@Module
@InstallIn(ViewModelComponent::class)
class MyModule:Application() {
    @Provides
    fun dispatchApp(): DispatchApp = DispatchApp()
}
