package com.example.scootboost.ui.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.scootboost.R


@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.logo), contentDescription ="logo",modifier.aspectRatio(1/1f))
}


@Composable
fun LogoAuth(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.ic_auth), contentDescription ="logo",modifier.aspectRatio(1/1f))
}