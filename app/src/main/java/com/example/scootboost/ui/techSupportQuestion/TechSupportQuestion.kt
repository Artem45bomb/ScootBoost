
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.theme.ScootBoostTheme

@Router(route = "techSupportQuestion", groupId = ["question"])
class TechSupportQuestion: RouterType


@Composable
fun TechSupport(modifier: Modifier = Modifier,questionText: String, answerText: String) {
    var isClicked by remember { mutableStateOf(false) };
    Column(modifier = Modifier
        .padding(horizontal = 8.dp)){
        TextButton(onClick = {
            isClicked = !isClicked;
        },
            modifier = Modifier.padding(horizontal = 4.dp)){
            Text(questionText,
                style = MaterialTheme.typography.displayMedium.copy(
                    MaterialTheme.colorScheme.secondary)
            )

        }
        AnimatedVisibility(isClicked){
            Text(answerText,
                modifier = Modifier.padding(top = 4.dp, start = 14.dp, bottom = 4.dp, end = 0.dp),
                style = MaterialTheme.typography.displaySmall.copy(
                    MaterialTheme.colorScheme.primary))
        }

        HorizontalDivider(thickness = 1.dp)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTechSupport() {
    ScootBoostTheme {
        TechSupport(modifier = Modifier.padding(horizontal = 4.dp),"Первый", "Второй")
    }

}


