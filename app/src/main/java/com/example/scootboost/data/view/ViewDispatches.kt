package com.example.scootboost.data.view

import androidx.lifecycle.ViewModel
import com.example.scootboost.data.android.DispatchApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
data class ViewDispatches @Inject constructor(val dispatchers: DispatchApp) :ViewModel()