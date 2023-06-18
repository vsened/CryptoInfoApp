package com.vsened.cryptoinfoapp.presentation.coins_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vsened.cryptoinfoapp.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
            )
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(coin) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = if(coin.isActive) "active" else "inactive",
                color = if(coin.isActive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(CenterVertically)
            )
        }
    }
}