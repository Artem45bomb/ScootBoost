package com.example.scootboost.component.user.techSupport

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.scootboost.R


@Composable
fun QuestionItem(modifier: Modifier = Modifier, questionText: String, answerText: String) {
    var isClicked by remember { mutableStateOf(false) };

    Column(modifier = modifier
        .padding(horizontal = 8.dp))
    {
        TextButton(onClick = {isClicked = !isClicked},
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.background,
                disabledContainerColor = MaterialTheme.colorScheme.background
            ),
            modifier = Modifier.padding(horizontal = 4.dp)){
            Text(questionText,
                style = MaterialTheme.typography.displayMedium.copy(
                    MaterialTheme.colorScheme.secondary)
            )
        }

        AnimatedVisibility(isClicked){
            Column(modifier = Modifier.fillMaxWidth()){
                Icon(
                    painterResource(id = R.drawable.btn_show_list),
                    "btn show list",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(answerText,
                    modifier = Modifier.padding(top = 4.dp, start = 14.dp, bottom = 4.dp, end = 0.dp),
                    style = MaterialTheme.typography.displayMedium.copy(
                        MaterialTheme.colorScheme.primary)
                )
            }
        }

        HorizontalDivider(thickness = 1.dp)

    }
}


