package com.example.scootboost.ui.logo

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.scootboost.R


@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.logo), contentDescription ="logo",modifier)
}