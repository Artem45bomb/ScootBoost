package com.example.scootboost.screen.techSupport


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.scootboost.component.user.techSupport.QuestionItem
import com.example.scootboost.data.model.Question
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.theme.ScootBoostTheme

@Router(route = "techSupport", groupId = ["techSupport"])
class TechSupportRouter: RouterType


@Composable
@Preview
fun TechSupportScreenTest(){
    ScootBoostTheme {
        val arrayOfQuestions = listOf(
            Question("Как зарегистрировать устройство в приложении?", "Никак"),
            Question("Как забронировать устройство?", "Тоже никак"),
            Question("Можно ли зарегистрироваться без привязки номера телефона?", "Нельзя"),
            Question("Как проложить навигационный маршрут", "тебе это не нужно"),
            Question("Как привязать карту к аккаунту?", "только заплатив"),
            Question("Что делать, если устройства нет на месте или оно находится в плохом состоянии?", "Ничего"),
        )
        //TechSupportScreen(arrayOfQuestions)
    }

}

@Composable
fun TechSupportScreen(
    allQuestions: List<Question>,
    navController: NavHostController
){
    var text by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
        Back(navController = navController)
        Text("Техническая поддержка",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            style =  MaterialTheme.typography.titleLarge.copy(
                MaterialTheme.colorScheme.secondary)
        )
        Text("Часто задаваемые вопросы",
            modifier = Modifier.padding(top = 44.dp, bottom = 26.dp, start = 24.dp, end= 0.dp),
            style = MaterialTheme.typography.displayMedium.copy(
                MaterialTheme.colorScheme.secondary)
        )
        for(question in allQuestions){
            QuestionItem(modifier = Modifier.padding(vertical = 0.dp),
                question.headerQuestion,
                question.answerQuestion)
        }

        Text("Свой вариант вопроса",
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
            style = MaterialTheme.typography.displayMedium.copy(
                MaterialTheme.colorScheme.secondary)
        )
        TextField(value = text,
            onValueChange = {text = it},
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp)
                .fillMaxWidth(fraction = 1f)
                .height(height = 36.dp)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(16.dp))
                .clip(shape = RoundedCornerShape(16.dp))
            ,
            label = {
                Text("Самоката нет на месте",
                    style = MaterialTheme.typography.displayMedium.copy(
                        color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                )
            }
            )
    }
}