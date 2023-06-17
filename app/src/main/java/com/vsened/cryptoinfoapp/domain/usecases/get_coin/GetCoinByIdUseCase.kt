package com.vsened.cryptoinfoapp.domain.usecases.get_coin

import com.vsened.cryptoinfoapp.common.Resource
import com.vsened.cryptoinfoapp.data.mappers.toCoinDetail
import com.vsened.cryptoinfoapp.domain.model.CoinDetail
import com.vsened.cryptoinfoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(
                Resource.Success(
                data = coin.toCoinDetail()
            ))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "An unexpected error"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "Check your internet connection"
                )
            )
        }
    }
}