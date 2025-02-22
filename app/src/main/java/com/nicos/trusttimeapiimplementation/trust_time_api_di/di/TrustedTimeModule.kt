package com.nicos.trusttimeapiimplementation.trust_time_api_di.di

import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.android.gms.time.TrustedTime
import com.google.android.gms.time.TrustedTimeClient
import com.nicos.trusttimeapiimplementation.trust_time_api_di.interfaces.TrustedTimeClientAccessor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TrustedTimeModule {

    @Provides
    @Singleton
    fun provideTrustedTimeClientAccessor(
        @ApplicationContext context: Context
    ): TrustedTimeClientAccessor {
        return object : TrustedTimeClientAccessor {
            override fun createClient(): Task<TrustedTimeClient> {
                return TrustedTime.createClient(context)
            }
        }
    }
}