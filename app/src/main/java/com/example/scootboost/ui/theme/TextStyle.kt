package com.example.scootboost.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

val baseText = TextStyle(
    fontWeight = FontWeight.W400,
    fontSize = TextUnit(16f,TextUnitType.Unspecified),
)

val baseRed = baseText.copy(
    color = Red
)

val base24Black = baseText.copy(
    color = Black_blue,
    fontSize = TextUnit(24f,TextUnitType.Unspecified)
)

val base30Black = baseText.copy(
    color = Black_blue,
    fontSize = 30.sp
)

val base20Light = baseText.copy(
    color = Light_blue,
    fontSize = TextUnit(20f,TextUnitType.Unspecified)
)

val base24Light = baseText.copy(
    color = Light_blue,
    fontSize = TextUnit(24f,TextUnitType.Unspecified)
)