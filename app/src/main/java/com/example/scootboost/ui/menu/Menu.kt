package com.example.scootboost.ui.menu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.R


@Composable
 fun Menu(modifier: Modifier = Modifier,visible:Boolean = true) {
    AnimatedVisibility(
        visible,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
        ){
            fullHeight -> -fullHeight
        },
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing)
        ){
            fullHeight -> -fullHeight
        }
    ) {
        Column(modifier = modifier
            .width(171.dp)
            .clip(RoundedCornerShape(bottomEnd = 20.dp)))
        {
            MenuItem(textItem = stringResource(R.string.settings_profile_item),onClick = { /*TODO*/ })
            HorizontalDivider(color = colorResource(R.color.blue_dark), thickness = 1.dp)
            MenuItem(textItem = stringResource(R.string.settings_about_us_item), onClick = { /*TODO*/ })
            HorizontalDivider(color = colorResource(R.color.blue_dark), thickness = 1.dp)
            MenuItem(textItem = stringResource(R.string.settings_item), onClick = { /*TODO*/ })
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MenuPreview() {

    Menu(modifier =Modifier.width(171.dp))
}