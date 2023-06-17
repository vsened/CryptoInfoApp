package com.vsened.cryptoinfoapp.presentation.coins_list

import com.vsened.cryptoinfoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
