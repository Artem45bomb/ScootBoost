package com.example.scootboost.screen.techSupport


import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.user.techSupport.QuestionItem
import com.example.scootboost.data.model.Question
import com.example.scootboost.data.view.Questions
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.theme.ScootBoostTheme

@Router(route = "techSupport", groupId = ["techSupport", "auth"])
class TechSupportRouter : RouterType


@Composable
@Preview
fun TechSupportScreenTest() {
    ScootBoostTheme {
        val arrayOfQuestions = listOf(
            Question("Как зарегистрировать устройство в приложении?", "Никак"),
            Question("Как забронировать устройство?", "Тоже никак"),
            Question("Можно ли зарегистрироваться без привязки номера телефона?", "Нельзя"),
            Question("Как проложить навигационный маршрут", "тебе это не нужно"),
            Question("Как привязать карту к аккаунту?", "только заплатив"),
            Question(
                "Что делать, если устройства нет на месте или оно находится в плохом состоянии?",
                "Ничего"
            ),
        )
        //TechSupportScreen(arrayOfQuestions)
    }

}


@Composable
fun TechSupportScreen(
    viewQuestions: Questions = viewModel(),
    navController: NavHostController
) {
    var text by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Back(navController = navController, modifier = Modifier.align(Alignment.Start).padding(horizontal = 4.dp, vertical = 8.dp))
                Text(
                    "Техническая поддержка",
                    style = MaterialTheme.typography.titleLarge.copy(
                        MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    "Часто задаваемые вопросы:",
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
                    "Свой вариант вопроса:",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                    style = MaterialTheme.typography.displayMedium.copy(
                        MaterialTheme.colorScheme.secondary
                    )
                )
                TextField(value = text,
                    onValueChange = { text = it },
                    maxLines = 5,
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 26.dp, start = 24.dp, end = 24.dp)
                        .fillMaxWidth(fraction = 1f)
                        .height(IntrinsicSize.Min)
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
                            text = "Самоката нет на месте",
                            style = MaterialTheme.typography.displayMedium.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    trailingIcon = {
                        Row(modifier = Modifier.fillMaxHeight().padding(top = 0.dp, bottom = 0.dp, end = 0.dp, start = 0.dp), verticalAlignment = Alignment.Bottom){
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
                )
            }
        },
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier
                .padding(it)
        ) {
            items(viewQuestions.questions) {
                QuestionItem(
                    modifier = Modifier.padding(vertical = 0.dp),
                    it.headerQuestion,
                    it.answerQuestion
                )
            }
        }
    }
}