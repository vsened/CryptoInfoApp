package com.vsened.cryptoinfoapp.presentation

sealed class Screen(val route: String) {
    object CoinsListScreen: Screen("coins_list")
    object CoinDetailScreen: Screen("coin_detail")
}
