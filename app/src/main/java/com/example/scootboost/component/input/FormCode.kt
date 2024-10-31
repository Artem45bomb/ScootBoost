package com.example.scootboost.component.input


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.ui.theme.ScootBoostTheme



@Composable
fun FormCode(
    modifier: Modifier = Modifier,
    code: String,
    onChangeValue: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        for ((currentIndex,element) in code.withIndex()) {
            CodeItem(
                value =if( element == ' ') "" else element.toString() ,
                onChangeValue = {
                    onChangeValue(code.mapIndexed{index,c ->if(index == currentIndex) it else c }.joinToString(""))
                },
                modifier = Modifier.width(53.dp)
            )
        }
    }
}

@Composable
fun CodeItem(
    modifier: Modifier = Modifier,
    value: String,
    onChangeValue: (Char) -> Unit
) {
    val onValueChange: (String) -> Unit = { input ->
        println("click")
        val isNum = Regex("^\\d+$")
        if (input.isEmpty()) {
            onChangeValue(' ')
        } else {
            val newChar = input.last()
            if(newChar.toString().matches(isNum)) onChangeValue(newChar)
        }
    }
    println("value456:$value")
    with(MaterialTheme) {
        TextField(
            value = value.run{ifEmpty{""}},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.background,
                unfocusedContainerColor = colorScheme.background
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            singleLine = true,
            onValueChange = onValueChange,
            modifier = modifier
                .aspectRatio(1f / 1f)
                .clip(shapes.small)
                .border(1.dp, colorScheme.secondary, shapes.small)
        )
    }
}



@Preview(showBackground = true, widthDp = 430)
@Composable
private fun Test() {
    var code by remember {
        mutableStateOf("    ")
    }

    ScootBoostTheme {
        FormCode(code = code) {
            code = it
        }
    }
}