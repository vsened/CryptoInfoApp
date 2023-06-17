package com.vsened.cryptoinfoapp.data.remote

import com.vsened.cryptoinfoapp.data.remote.dto.CoinDetailDto
import com.vsened.cryptoinfoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPapricaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}