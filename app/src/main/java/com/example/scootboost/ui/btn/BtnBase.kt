package com.example.scootboost.ui.btn


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.scootboost.ui.theme.ScootBoostTheme


@Composable
fun BtnBase(modifier: Modifier = Modifier,enabled:Boolean = true,text:String, colorText:Color, colorButton:Color, onClick:() -> Unit) {
    TextButton(
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = colorButton),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
    ) {
        Text(text = text, style = MaterialTheme.typography.displayLarge.copy(color = colorText), textAlign = TextAlign.Center)
    }
}

@Composable
fun BtnIcon(modifier: Modifier = Modifier,enabled: Boolean = true,@DrawableRes id:Int,description:String, colorButton:Color, onClick: () -> Unit) {
    Button(
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = colorButton),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
    ) {
        Image(painter = painterResource(id),description,modifier)
    }
}

@Composable
fun BtnLight(modifier: Modifier = Modifier,text:String,enabled: Boolean = true,onClick:() -> Unit) {
    with(MaterialTheme.colorScheme) {
        BtnBase(modifier,enabled = enabled, text = text, colorText =secondary, colorButton = primary, onClick = onClick)
    }
}

@Composable
fun BtnBlack(modifier: Modifier = Modifier,enabled: Boolean = true,text:String,onClick:() -> Unit) {
    with(MaterialTheme.colorScheme) {
        BtnBase(modifier,enabled = enabled ,text = text, colorText =primary, colorButton = secondary, onClick = onClick)
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

