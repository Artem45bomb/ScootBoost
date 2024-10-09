package com.example.scootboost.ui.btn.sign

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.R
import com.example.scootboost.ui.theme.base24Black
import com.example.scootboost.ui.theme.base24Light


@Composable
fun SignBtnMain(text:String,onClick:()->Unit,modifier: Modifier = Modifier) {
    Button(onClick=onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults
        .buttonColors()
        .copy(containerColor = colorResource(R.color.blue_light)),
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(1f)

    ){
        Text(text, style = base24Black)
    }
}

@Composable
fun SignBtnAction(text:String,onClick:()->Unit,modifier: Modifier = Modifier) {
    Button(onClick=onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults
            .buttonColors()
            .copy(containerColor = colorResource(R.color.blue_dark)),
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(1f)

    ){
        Text(text, style = base24Light)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PSignBtn() {
    Column {
        SignBtnMain(text = stringResource(R.string.sign_btn_signin), onClick = { /*TODO*/ })
        SignBtnAction(text = stringResource(R.string.sign_btn_signin), onClick = { /*TODO*/ })
    }
}

