package com.example.scootboost.component.company

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import kotlinx.coroutines.launch


@Composable
fun FormLiability(
    modifier: Modifier = Modifier,
    value: TypeLiability,
    isShow: Boolean = false,
    onChangeShow:(Boolean) -> Unit,
    onChangeValue: (TypeLiability) -> Unit
) {

    val scope = rememberCoroutineScope()
    val animateHeight = animateDpAsState(
        if (isShow) 150.dp else 0.dp,
        animationSpec = tween(durationMillis = 450),
        label = "height"
    )
    val animateRotate = remember { Animatable(0f) }
    val animatePadding = animateDpAsState(
        if (isShow) 10.dp else 0.dp,
        animationSpec = if (isShow) {
            tween(durationMillis = 356, easing = LinearEasing)
        } else {
            tween(durationMillis = 487)
        },
        label = "padding-to"
    )
    val animatePaddingHorizontal = animateDpAsState(
        if (!isShow) 15.dp else 0.dp,
        animationSpec = if (isShow) {
            tween(durationMillis = 356, easing = LinearEasing)
        } else {
            tween(durationMillis = 562)
        },
        label = "padding-to"
    )

    val onClick = {
        scope.launch {
            animateRotate.animateTo(if (isShow) 0f else -90f)
            onChangeShow(!isShow)
        }
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
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
                        style = typography.displaySmall,
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
        }
        Surface(
            color = colorScheme.background,
            modifier = modifier
                .padding(top = animatePadding.value, start = animatePaddingHorizontal.value, end = animatePaddingHorizontal.value)
                .fillMaxWidth()
                .height(animateHeight.value)
                .clip(shapes.medium)
        ) {
            ListLiability(
                isVisible = isShow,
                onChangeValue = onChangeValue
            )
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
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .clip(shapes.medium)
            .border(1.dp, colorScheme.secondary, shapes.medium)
    ) {
        for ((index, type) in TypeLiability.entries.withIndex()) {
            Item(value = type, onEnter = onChangeValue, isVisible = isVisible, index = index)
        }

    }
}

@Composable
private fun Item(
    modifier: Modifier = Modifier,
    value: TypeLiability,
    isVisible: Boolean,
    index: Int,
    onEnter: (TypeLiability) -> Unit
) {
    var width by remember { mutableIntStateOf(0) }
    val offsetX by animateDpAsState(
        targetValue = if (!isVisible) (-(width / 2)).dp else 0.dp,
        animationSpec = tween(durationMillis = 775, delayMillis = index * 45),
        label = "offsetX" // Задержка в 1 секунду
    )



    Button(
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = None),
        onClick = { onEnter(value) },
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp)
            .onGloballyPositioned { coordinates ->
                if(width == 0) width = coordinates.size.width
            }
    ) {
        Text(
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.W300,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center,
            color = colorScheme.primary,
            text = value.toString(),
            modifier = Modifier.offset(offsetX, 0.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
private fun Prev() {
    ScootBoostTheme {
        ProvideTextStyle(
            value = MaterialTheme.typography.bodyMedium
        ) {
            var isVisible by remember { mutableStateOf(false) }
            FormLiability(value = TypeLiability.None, isShow = isVisible, onChangeShow = {isVisible = it}) {
            }
        }
    }
}