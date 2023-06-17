package com.vsened.cryptoinfoapp.di

import com.vsened.cryptoinfoapp.common.Constants
import com.vsened.cryptoinfoapp.data.remote.CoinPapricaApi
import com.vsened.cryptoinfoapp.data.repository.CoinRepositoryImpl
import com.vsened.cryptoinfoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPapricaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPapricaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}