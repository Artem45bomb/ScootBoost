package com.example.scootboost.api.auth.oauth

import android.util.Log
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialResponse
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

fun handleSignInGoogle(result: GetCredentialResponse) {
    // Handle the successfully returned credential.
    when (val credential = result.credential) {
        is CustomCredential -> {
            if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                try {
                    // Use googleIdTokenCredential and extract id to validate and
                    // authenticate on your server.
                    val googleIdTokenCredential =
                        GoogleIdTokenCredential.createFrom(credential.data)

                    // TODO: Send [googleIdTokenCredential.idToken] to your backend
                } catch (e: GoogleIdTokenParsingException) {
                    Log.e("MainActivity", "handleSignIn:", e)
                }
            } else {
                // Catch any unrecognized custom credential type here.
                Log.e("MainActivity", "Unexpected type of credential")
            }
        }

        else -> {
            // Catch any unrecognized credential type here.
            Log.e("MainActivity", "Unexpected type of credential")
        }
    }
}