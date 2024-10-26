package com.example.scootboost.data.view

import androidx.lifecycle.ViewModel
import com.example.scootboost.data.model.Question

val a = listOf(
Question("Как зарегистрировать устройство в приложении?", "Никак"),
Question("Как забронировать устройство?", "Тоже никак"),
Question("Можно ли зарегистрироваться без привязки номера телефона?", "Нельзя"),
Question("Как проложить навигационный маршрут", "тебе это не нужно"),
Question("Как привязать карту к аккаунту?", "только заплатив"),
Question("Что делать, если устройства нет на месте или оно находится в плохом состоянии?", "Ничего"),
)

data class Questions(var questions:List<Question> = a):ViewModel()
