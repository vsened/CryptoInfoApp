package com.vsened.cryptoinfoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vsened.cryptoinfoapp.presentation.coin_detail.CoinDetailScreen
import com.vsened.cryptoinfoapp.presentation.coins_list.CoinListScreen
import com.vsened.cryptoinfoapp.presentation.ui.theme.CryptoInfoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInfoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinsListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinsListScreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route +
                                    "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}