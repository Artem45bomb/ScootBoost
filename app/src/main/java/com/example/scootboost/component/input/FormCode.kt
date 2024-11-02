package com.example.scootboost.component.input


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.scootboost.ui.theme.None
import com.example.scootboost.ui.theme.ScootBoostTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun FormCode(
    modifier: Modifier = Modifier,
    code: String,
    isError:Boolean,
    onChangeValue: (String) -> Unit
) {
    val shake = remember {Animatable(0f)}
    val background by animateColorAsState(
        if(isError) Color.Red else None,
        label = "color",
        animationSpec = tween(durationMillis = 50)
    )

    LaunchedEffect(isError) {
        if (isError) {
            for (i in 0..10) {
                when (i % 2) {
                    0 -> shake.animateTo(5f, spring(stiffness = 100_000f))
                    else -> shake.animateTo(-5f, spring(stiffness = 100_000f))
                }
            }
            shake.animateTo(0f)
        }
    }


    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        for ((currentIndex,element) in code.withIndex()) {
            with(MaterialTheme) {
                Box {
                    CodeItem(
                        value = if (element == ' ') "" else element.toString(),
                        onChangeValue = {
                            onChangeValue(code.mapIndexed { index, c -> if (index == currentIndex) it else c }
                                .joinToString(""))
                        },
                        modifier = Modifier
                            .width(53.dp)
                            .offset { IntOffset(shake.value.roundToInt(), y = 0) }
                            .shadow(elevation = 5.dp, shape = shapes.small, spotColor = background)
                    )
                }
            }
        }
    }
}

@Composable
fun CodeItem(
    modifier: Modifier = Modifier,
    value: String,
    onChangeValue: (Char) -> Unit,
) {
    val onValueChange: (String) -> Unit = { input ->
        val isNum = Regex("^\\d+$")
        if (input.isEmpty()) {
            onChangeValue(' ')
        } else {
            val newChar = input.last()
            if(newChar.toString().matches(isNum)) onChangeValue(newChar)
        }
    }

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



@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
private fun Test() {

    var code by remember {
        mutableStateOf("    ")
    }
    var isError by remember {
        mutableStateOf(false)
    }

    ScootBoostTheme {
        Column {
            Button(onClick ={isError = !isError} ) {
                Text(text = "click:$isError")
            }
            FormCode(code = code, isError = isError) {
                code = it
            }
        }
    }
}