package com.example.scootboost.config

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

sealed class NavigationConfig {
    companion object{
        val fadeIn = fadeIn(animationSpec = tween(durationMillis = 0))
        val fadeOut = fadeOut(animationSpec = tween(durationMillis = 0))
    }
}