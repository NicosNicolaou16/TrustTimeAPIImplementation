package com.nicos.trusttimeapiimplementation

import android.app.Application
import android.util.Log
import com.google.android.gms.time.TrustedTimeClient
import com.nicos.trusttimeapiimplementation.trust_time_api_di.interfaces.TrustedTimeClientAccessor
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TrustTimeApplication : Application() {

    @Inject
    lateinit var trustedTimeClientAccessor: TrustedTimeClientAccessor

    var trustedTimeClient: TrustedTimeClient? = null
        private set

    override fun onCreate() {
        super.onCreate()
        trustedTimeClientAccessor.createClient().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Stash the client
                trustedTimeClient = task.result
            } else {
                // Handle error, maybe retry later
                val exception = task.exception
                Log.d("trustTimeException", exception?.message.toString())
            }
        }
    }
}