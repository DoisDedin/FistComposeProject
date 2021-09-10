package com.example.fistprojectcompose.data.remote.dto

import com.example.fistprojectcompose.domain.model.a.Coin

data class CoinDto(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name =  name,
        rank = rank,
        symbol = symbol
    )
}