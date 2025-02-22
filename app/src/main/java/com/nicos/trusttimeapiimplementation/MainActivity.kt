package com.nicos.trusttimeapiimplementation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nicos.trusttimeapiimplementation.ui.theme.TrustTimeAPIImplementationTheme
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val currentTimeMillis = trustTimeApi()
        setContent {
            TrustTimeAPIImplementationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        currentTimeMillis = currentTimeMillis,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun trustTimeApi(): Long {
        val myApp = applicationContext as TrustTimeApplication
        val currentTimeMillis =
            myApp.trustedTimeClient?.computeCurrentUnixEpochMillis()
                ?: System.currentTimeMillis()
        Log.d(
            "trustedTimeApi",
            "$currentTimeMillis " + SimpleDateFormat(
                "dd/MM/yyyy HH:mm",
                Locale.UK
            ).format(Date(currentTimeMillis ?: 0L))
        )
        return currentTimeMillis
    }
}

@Composable
fun Greeting(currentTimeMillis: Long, modifier: Modifier = Modifier) {
    val dateAndTime = "$currentTimeMillis " + SimpleDateFormat(
        "dd/MM/yyyy HH:mm",
        Locale.UK
    ).format(Date(currentTimeMillis ?: 0L))
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = dateAndTime,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrustTimeAPIImplementationTheme {
        Greeting(currentTimeMillis = System.currentTimeMillis())
    }
}