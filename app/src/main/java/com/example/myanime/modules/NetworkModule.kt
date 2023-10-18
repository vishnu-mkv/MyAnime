package com.example.myanime.modules

import com.example.myanime.config.constants
import com.example.myanime.services.AnimeService
import com.example.myanime.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named("authRetorfit")
    fun provideNetworkService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAuthService(@Named("authRetorfit") retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Named("animeRetrofit")
    fun provideAnimeNetworkService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(constants.ANIME_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAnimeService(@Named("animeRetrofit") retrofit: Retrofit): AnimeService {
        return retrofit.create(AnimeService::class.java)
    }

}