package com.example.scootboost.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.R
import com.example.scootboost.component.custom.Input
import com.example.scootboost.ui.theme.base20Light
import com.example.scootboost.ui.theme.baseRed


@Composable fun FormInput(
    modifier: Modifier = Modifier,
    value:String,
    placeholder: String = "",
    type:String = "text",
    onChangeValue:(String) -> Unit,
    errorCheck:Regex? = null,
    errorValue: String = "",
) {
    var error by remember {
        mutableStateOf("")
    }

    var isShow by remember {
        mutableStateOf(true)
    }
    
    val clickEye:() -> Unit = { 
        isShow = !isShow
    }

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Unspecified)
                .border(1.dp,MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(20.dp))
        ) {
            Input(
                value = value,
                textStyle = TextStyle(color = Color.Black),
                onValueChange ={

                    error = if(errorCheck != null && it.matches(errorCheck)) "" else errorValue
                    onChangeValue(it)
                },
                visualTransformation =when(type){
                    "password" ->if(isShow) VisualTransformation.None else PasswordVisualTransformation()
                    else -> VisualTransformation.None
                },
                colors = OutlinedTextFieldDefaults.colors(

                    selectionColors = TextSelectionColors(
                        backgroundColor = MaterialTheme.colorScheme.primary,
                        handleColor = Color.Red
                    ),
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,

                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                placeholder = {Text(placeholder, style = base20Light)},
                contentPadding = PaddingValues(horizontal = 15.dp),
                modifier = Modifier
                    .height(41.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.8f)

            )
            if(type == "password") {
                IconButton(
                    onClick = clickEye,
                    modifier = Modifier
                        .width(24.dp)
                ) {
                    when (isShow) {
                        true -> Icon(
                            painter = painterResource(R.drawable.hide), contentDescription = "hide password",
                            modifier = Modifier.width(24.dp)
                        )
                        false -> Icon(painter = painterResource(R.drawable.eye), contentDescription ="show password",
                            modifier = Modifier.width(24.dp))
                    }
                }
                Spacer(modifier = Modifier
                    .height(7.dp)
                    .width(7.dp))
            }
        }
        if(error != "")
            Text(error,
                style = baseRed,
                modifier =  Modifier.padding(top = 4.dp, start = 4.dp)
            )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PFormInput() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val inputString = "Check if this string contains only English characters"
    val englishRegex = Regex("^[a-zA-Z]+$")
    val errorMap = mapOf(englishRegex to inputString)
    FormInput(value = text, placeholder = "Hi", onChangeValue = {text=it}, errorCheck = englishRegex , errorValue = inputString)
}