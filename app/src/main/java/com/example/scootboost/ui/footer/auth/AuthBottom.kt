package com.example.scootboost.ui.footer.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.ui.theme.ScootBoostTheme


@Composable
fun AuthBottom(modifier: Modifier = Modifier,onNavClick:(RouteBase) -> Unit) {
   Row(
       horizontalArrangement = Arrangement.Center,
       modifier = modifier
           .fillMaxWidth()
           .background(MaterialTheme.colorScheme.secondary)
   ){
       with(MaterialTheme){

           Text(
               style = typography.displayMedium.copy(color = colorScheme.primary),
               text = "Политика конфидициальности ⓘ",
               textDecoration = TextDecoration.Underline,
               modifier = Modifier
                   .padding(vertical = 7.dp)
                   .pointerInput(Unit) {
                       detectTapGestures(
                           onPress = {

                           }
                       )
                   }
           )
       }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PAuthBottom() {
    ScootBoostTheme {
        AuthBottom(onNavClick = {})
    }
}