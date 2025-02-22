package com.nicos.trusttimeapiimplementation.trust_time_api_di.interfaces

import com.google.android.gms.tasks.Task
import com.google.android.gms.time.TrustedTimeClient

interface TrustedTimeClientAccessor {
    fun createClient(): Task<TrustedTimeClient>
}