package com.example.scootboost.ui.btn.sign.auth

import android.credentials.GetCredentialException
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.example.scootboost.R
import com.example.scootboost.ui.btn.BtnIcon
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun GoogleSignButton(modifier: Modifier = Modifier,onClick:suspend () -> Unit) {
    BtnIcon(
        modifier,
        id = R.drawable.google_logo,
        description = "google icon",
        colorButton = MaterialTheme.colorScheme.primary,
        onClick = {CoroutineScope(Dispatchers.Main).launch{onClick()} }

    )
}