package com.example.scootboost.ui.btn


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.scootboost.ui.theme.ScootBoostTheme


@Composable
fun BtnBase(modifier: Modifier = Modifier,text:String,colorText:Color,colorButton:Color,onClick:() -> Unit) {
    TextButton(
        colors = ButtonDefaults.buttonColors(containerColor = colorButton),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
    ) {
        Text(text = text, style = MaterialTheme.typography.displayLarge.copy(color = colorText))
    }
}

@Composable
fun BtnLight(modifier: Modifier = Modifier,text:String,onClick:() -> Unit) {
    with(MaterialTheme.colorScheme) {
        BtnBase(modifier, text = text, colorText =secondary, colorButton = primary, onClick = onClick)
    }
}

@Composable
fun BtnBlack(modifier: Modifier = Modifier,text:String,onClick:() -> Unit) {
    with(MaterialTheme.colorScheme) {
        BtnBase(modifier, text = text, colorText =primary, colorButton = secondary, onClick = onClick)
    }
}

@Preview
@Composable
private fun PBtnBase() {
    ScootBoostTheme {
        with(MaterialTheme.colorScheme){
            BtnBase(text = "Hi", colorText = primary, colorButton = secondary) {

            }
        }
    }
}

