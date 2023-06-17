package com.vsened.cryptoinfoapp.domain.usecases.get_coins

import com.vsened.cryptoinfoapp.common.Resource
import com.vsened.cryptoinfoapp.data.mappers.toCoin
import com.vsened.cryptoinfoapp.domain.model.Coin
import com.vsened.cryptoinfoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(
                data = coins.map { it.toCoin() }
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