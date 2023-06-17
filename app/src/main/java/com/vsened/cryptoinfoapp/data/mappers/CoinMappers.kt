package com.vsened.cryptoinfoapp.data.mappers

import com.vsened.cryptoinfoapp.data.remote.dto.CoinDetailDto
import com.vsened.cryptoinfoapp.data.remote.dto.CoinDto
import com.vsened.cryptoinfoapp.data.remote.dto.TeamMember
import com.vsened.cryptoinfoapp.domain.model.Coin
import com.vsened.cryptoinfoapp.domain.model.CoinDetail

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}

fun Coin.toCoinDto():CoinDto {
    return CoinDto(
        id = id,
        isActive = isActive,
        isNew = false,
        name = name,
        rank = rank,
        symbol = symbol,
        type = ""
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}