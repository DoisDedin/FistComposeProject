package com.example.fistprojectcompose.domain.repository

import com.example.fistprojectcompose.data.remote.dto.CoinDetailDto
import com.example.fistprojectcompose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}