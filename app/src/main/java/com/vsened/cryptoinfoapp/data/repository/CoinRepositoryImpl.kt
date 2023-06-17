package com.vsened.cryptoinfoapp.data.repository

import com.vsened.cryptoinfoapp.data.remote.CoinPapricaApi
import com.vsened.cryptoinfoapp.data.remote.dto.CoinDetailDto
import com.vsened.cryptoinfoapp.data.remote.dto.CoinDto
import com.vsened.cryptoinfoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPapricaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}