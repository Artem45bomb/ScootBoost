package com.example.scootboost.screen.techSupport


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.user.techSupport.QuestionItem
import com.example.scootboost.data.view.Questions
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.nav.Back

@Router(route = "techSupport", groupId = ["techSupport", "auth"])
class TechSupportRouter : RouterType


@Composable
fun TechSupportScreen(
    viewQuestions: Questions = viewModel(),
    navController: NavHostController
) {
    var text by remember {
        mutableStateOf("")
    }
    val scrollState = rememberLazyListState()
    var questionPosition by remember { mutableStateOf(0) }
    var shouldScroll by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Back(navController = navController, modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 4.dp, vertical = 8.dp))
                Text(
                    text = stringResource(R.string.text_techsupport),
                    style = MaterialTheme.typography.titleLarge.copy(
                        MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    text = stringResource(R.string.text_FAQ),
                    modifier = Modifier.padding(
                        top = 44.dp,
                        bottom = 26.dp,
                        start = 24.dp,
                        end = 0.dp
                    ),
                    style = MaterialTheme.typography.displayMedium.copy(
                        MaterialTheme.colorScheme.secondary
                    )
                )

            }
        },
        bottomBar = {
            Column(verticalArrangement = Arrangement.Bottom) {
                Text(
                    text = stringResource(R.string.text_your_question),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                    style = MaterialTheme.typography.displayMedium.copy(
                        MaterialTheme.colorScheme.secondary
                    )
                )
                TextField(value = text,
                    onValueChange = { text = it },
                    maxLines = 5,

                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .animateContentSize()
                        .padding(top = 12.dp, bottom = 26.dp, start = 24.dp, end = 24.dp)
                        .fillMaxWidth(fraction = 1f)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(shape = RoundedCornerShape(16.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        unfocusedContainerColor = MaterialTheme.colorScheme.background
                    ),
                    textStyle = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.secondary, lineHeight = 23.sp),
                    placeholder = {
                        Text(
                            text = stringResource(R.string.text_input),
                            style = MaterialTheme.typography.displayMedium.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    trailingIcon = {
                        AnimatedVisibility(true) {
                            Row(modifier = Modifier
                                .fillMaxHeight()
                                .animateContentSize(animationSpec = spring (
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                ))
                                .padding(top = 0.dp, bottom = 0.dp, end = 0.dp, start = 0.dp),
                                verticalAlignment = Alignment.Bottom){
                                Icon(
                                    painterResource(id = R.drawable.ic_video),
                                    "camera icon ",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 18.dp)
                                )
                                Image(
                                    painter=painterResource(id = R.drawable.ic_confirm),
                                    contentDescription ="confirm input",
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
                                )
                            }
                        }
                    }
                )
            }
        },
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            state = scrollState,
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier
                .padding(it)
        ) {
            items(viewQuestions.questions) { question ->
                QuestionItem(
                    modifier = Modifier
                        .padding(vertical = 0.dp),
                    question.headerQuestion,
                    question.answerQuestion,
                )
            }

        }
    }
}