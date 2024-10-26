package com.example.scootboost.component.company

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scootboost.R
import com.example.scootboost.data.model.company.TypeLiability
import com.example.scootboost.ui.theme.None
import com.example.scootboost.ui.theme.ScootBoostTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun FormLiability(modifier: Modifier = Modifier, onChangeValue: (TypeLiability) -> Unit) {
    var value: TypeLiability by remember {
        mutableStateOf(TypeLiability.None)
    }
    val scope = rememberCoroutineScope()
    var isShow by remember {
        mutableStateOf(false)
    }
    val animateRotate = remember { Animatable(0f) }

    val onClick = {
        scope.launch {
            animateRotate.animateTo(if (isShow) 0f else -90f)
            isShow = !isShow
        }
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        with(MaterialTheme) {
            Surface(
                color = colorScheme.background,
                modifier = modifier
                    .clip(shapes.medium)
                    .fillMaxWidth()
                    .border(1.dp, colorScheme.secondary, shapes.medium)
                    .clickable { onClick() }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        style = typography.displayLarge.copy(
                            fontWeight = FontWeight.W300,
                            fontSize = 16.sp
                        ),
                        color = colorScheme.primary,
                        text = if (value == TypeLiability.None) "Юридическая ответственность" else value.toString()
                    )
                    Icon(
                        tint = colorScheme.secondary,
                        painter = painterResource(R.drawable.btn_show_list),
                        contentDescription = if (value != TypeLiability.None) "btn show list" else "btn hide list",
                        modifier = Modifier.rotate(animateRotate.value)
                    )
                }
            }
                AnimatedVisibility(visible = isShow) {
                    ListLiability(isVisible = isShow) {
                        value = it
                    }
                }

        }
    }

}

@Composable
fun ListLiability(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    onChangeValue: (TypeLiability) -> Unit
) {
    Column(
        modifier = modifier
            .clip(shapes.medium)
            .border(1.dp, colorScheme.secondary, shapes.medium)
    ) {
        Item(value = TypeLiability.IP, onEnter = onChangeValue, isVisible = isVisible)
        Item(value = TypeLiability.None, onEnter = onChangeValue, isVisible = isVisible)
    }
}

@Composable
private fun Item(
    modifier: Modifier = Modifier,
    value: TypeLiability,
    isVisible: Boolean,
    onEnter: (TypeLiability) -> Unit
) {
    var width by remember { mutableIntStateOf(0) }
    val offsetX by animateDpAsState(
        targetValue =if(!isVisible) (-(width/2)).dp else 0.dp,
        animationSpec = tween(durationMillis = 2000), label = "offsetX" // Задержка в 1 секунду
    )



    Button(
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = None),
        onClick = { onEnter(value) },
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned{ coordinates ->
                width = coordinates.size.width
            }
    ) {
        Text(
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.W300,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center,
            color = colorScheme.primary,
            text = value.toString(),
            modifier = Modifier.offset(offsetX,0.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 430)
@Composable
private fun Prev() {
    ScootBoostTheme {
        ProvideTextStyle(
            value = MaterialTheme.typography.bodyMedium
        ) {
            FormLiability {
            }
        }
    }
}