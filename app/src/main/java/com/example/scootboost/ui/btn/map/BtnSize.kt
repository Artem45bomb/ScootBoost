package com.example.scootboost.ui.btn.map

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scootboost.ui.theme.Light_blue
import com.example.scootboost.ui.theme.base30Black


@Composable
private fun BtnSize(onClick:() -> Unit,modifier: Modifier = Modifier,children:@Composable () -> Unit) {
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Light_blue
        ),
        modifier = modifier
            .width(74.dp)
            .height(74.dp)
            .clip(CircleShape)
    ) {
        children()
    }
}

@Composable
fun BtnAdd(onClick: () -> Unit,modifier: Modifier = Modifier){
    BtnSize(onClick = onClick,modifier) {
        Text("+", style = base30Black)
    }
}

@Composable
fun BtnMinus(onClick: () -> Unit,modifier: Modifier = Modifier){
    BtnSize(onClick = onClick,modifier) {
        Text("-", style = base30Black, fontSize = 36.sp)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BtnSize() {
    BtnMinus(onClick = { /*TODO*/ })
}