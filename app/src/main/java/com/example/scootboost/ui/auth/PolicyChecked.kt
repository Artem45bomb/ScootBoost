package com.example.scootboost.ui.auth

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.scootboost.R


@Composable
fun PolicyChecked(value:Boolean,onChange:(Boolean) -> Unit,modifier: Modifier = Modifier) {
    Row (verticalAlignment = Alignment.CenterVertically, modifier = modifier){
        with(MaterialTheme) {
            Checkbox(
                checked = value,
                onCheckedChange = onChange,
                colors = CheckboxDefaults.colors(

                )
            )
            Text(
                text = stringResource(R.string.checkbox_confidentiality_policy),
                style = typography.labelSmall.copy(colorScheme.secondary)
            )
        }
    }
}