package com.example.scootboost.ui.auth.nav

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.ui.theme.Black_blue
import com.example.scootboost.ui.theme.Light_blue
import com.example.scootboost.ui.theme.base24Black
import com.example.scootboost.ui.theme.base24Light


@Composable
fun BtnNav(modifier: Modifier = Modifier) {

    Row(modifier.fillMaxWidth()) {
        Button(
            shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
            onClick = {
            /*TODO*/

            },
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Light_blue
            ),
            modifier = Modifier.weight(1f)) {
            Text("ll",style = base24Black)
        }
        Button(
            shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Black_blue
            ),
            modifier = Modifier.weight(1f)) {
            Text("Hi",style = base24Light)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PBtnNav() {
    BtnNav()
}