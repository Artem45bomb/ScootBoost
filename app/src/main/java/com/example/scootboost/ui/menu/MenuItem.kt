package com.example.scootboost.ui.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.R
import com.example.scootboost.ui.theme.baseText


@Composable
fun MenuItem(textItem:String,
             onClick:()->Unit,
             modifier: Modifier = Modifier) {
    Button(onClick = onClick,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults
            .buttonColors()
            .copy(containerColor = colorResource(R.color.blue_light)),
        modifier = modifier
            .padding(0.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .weight(1f)
        ){
            Text(
                text = textItem,
                color = colorResource(R.color.blue_dark),
                style = baseText
            )
        }
    }
}


@Preview
@Composable
private fun MenuItemPreview() {
    MenuItem(textItem = "Profile", onClick = {})
}