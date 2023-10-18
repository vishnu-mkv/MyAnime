package com.example.myanime.modules

import android.content.Context
import com.example.myanime.services.PreferenceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Provides
    fun providePreference(
        @ApplicationContext context: Context
    ): PreferenceService {
        return PreferenceService(context)
    }
}