package com.example.scootboost.data.di

import android.app.Application
import com.example.scootboost.data.android.DispatchApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


typealias R = Retrofit

@HiltAndroidApp
class App :Application()


@Module
@InstallIn(ViewModelComponent::class)
class MyModule:Application() {
    @Provides
    fun dispatchApp(): DispatchApp = DispatchApp()
}