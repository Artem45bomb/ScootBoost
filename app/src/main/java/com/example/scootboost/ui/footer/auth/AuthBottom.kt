package com.example.scootboost.ui.footer.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.ui.theme.ScootBoostTheme


@Composable
fun AuthBottom(modifier: Modifier = Modifier,onNavClick:(RouteBase) -> Unit) {
   Surface(modifier = modifier.fillMaxWidth()){
        TextButton(contentPadding = PaddingValues(0.dp),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .padding(0.dp)){
            Text(
                text = "Политика конфидициальностиⓘ",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(vertical = 7.dp)
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