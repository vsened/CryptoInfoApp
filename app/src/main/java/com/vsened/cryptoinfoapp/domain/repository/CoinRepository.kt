package com.vsened.cryptoinfoapp.domain.repository

import com.vsened.cryptoinfoapp.data.remote.dto.CoinDetailDto
import com.vsened.cryptoinfoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}