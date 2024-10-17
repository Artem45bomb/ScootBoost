package com.example.scootboost.data.android

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class DispatchApp {
    val io: CoroutineDispatcher = Dispatchers.IO
    val def:CoroutineDispatcher = Dispatchers.Default
    val un:CoroutineDispatcher = Dispatchers.Unconfined
    val main:CoroutineDispatcher = Dispatchers.Main
}