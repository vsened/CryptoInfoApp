package com.vsened.cryptoinfoapp.presentation.coin_detail

import com.vsened.cryptoinfoapp.domain.model.Coin
import com.vsened.cryptoinfoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
