package com.vsened.cryptoinfoapp.presentation.coins_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vsened.cryptoinfoapp.presentation.Screen
import com.vsened.cryptoinfoapp.presentation.coins_list.components.CoinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.value.coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route +
                        "?symbol=${it.symbol}")
                    }
                )
                
            }
        }
        if (state.value.error.isNotBlank()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = state.value.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}