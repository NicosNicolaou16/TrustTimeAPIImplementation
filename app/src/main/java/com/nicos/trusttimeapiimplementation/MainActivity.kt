package com.nicos.trusttimeapiimplementation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.time.TrustedTime
import com.google.android.gms.time.TrustedTimeClient
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
        val currentTimeMillis = trustTimeApiWithDependencyInjection()
        setContent {
            TrustTimeAPIImplementationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrustTime(
                        currentTimeMillisWithApplicationInitialization = currentTimeMillis,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    /**
     * This method uses the initialization from the Application class of the app, allowing you to access the time throughout the entire application
     * */
    private fun trustTimeApiWithDependencyInjection(): Long {
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
fun TrustTime(currentTimeMillisWithApplicationInitialization: Long, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.trust_time_with_dependency_injection))
        TrustTimeFromApplicationWithDependencyInjection(
            currentTimeMillisWithApplicationInitialization = currentTimeMillisWithApplicationInitialization,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(stringResource(R.string.trust_time_without_dependency_injection))
        TrustTimeWithoutDependencyInjection(
            modifier = modifier
        )
    }
}

/**
 * This implementation uses Dependency Injection, with the initialization occurring in the Application class (allowing you to access the time throughout the entire application).
 * Note: Additionally, if you want to use dependency injection with initialization inside the activity, you can copy the setup from the Application class and call directly "trustedTimeClient".
 * */
@Composable
fun TrustTimeFromApplicationWithDependencyInjection(
    currentTimeMillisWithApplicationInitialization: Long,
    modifier: Modifier
) {
    val dateAndTime = "$currentTimeMillisWithApplicationInitialization " + SimpleDateFormat(
        "dd/MM/yyyy HH:mm",
        Locale.UK
    ).format(Date(currentTimeMillisWithApplicationInitialization))
    Text(
        text = dateAndTime,
    )
}

/**
 * This implementation is a local initialization without using Dependency Injection.
 * */
@Composable
fun TrustTimeWithoutDependencyInjection(
    modifier: Modifier
) {
    // Get Context
    val context = LocalContext.current

    // This variable stores the instance of the TrustedTimeClient.
    var trustedTimeClient: TrustedTimeClient? = null

    // Callback to get instance
    TrustedTime.createClient(context).addOnCompleteListener {
        if (it.isSuccessful) {
            trustedTimeClient = it.result
        } else {
            val exception = it.exception
        }
    }

    var currentTimeMillisWithoutDependenciesInjection by remember { mutableLongStateOf(0L) }

    // Get the date/time in milliseconds.
    currentTimeMillisWithoutDependenciesInjection =
        trustedTimeClient?.computeCurrentUnixEpochMillis() ?: System.currentTimeMillis()


    val dateAndTime = "$currentTimeMillisWithoutDependenciesInjection " + SimpleDateFormat(
        "dd/MM/yyyy HH:mm",
        Locale.UK
    ).format(Date(currentTimeMillisWithoutDependenciesInjection))

    if (currentTimeMillisWithoutDependenciesInjection != 0L) {
        Text(
            text = dateAndTime,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrustTimeAPIImplementationTheme {
        TrustTime(currentTimeMillisWithApplicationInitialization = System.currentTimeMillis())
    }
}