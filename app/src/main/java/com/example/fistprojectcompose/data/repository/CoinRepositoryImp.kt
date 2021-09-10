package com.example.fistprojectcompose.data.repository

import com.example.fistprojectcompose.data.remote.CoinPaprikaApi
import com.example.fistprojectcompose.data.remote.dto.CoinDetailDto
import com.example.fistprojectcompose.data.remote.dto.CoinDto
import com.example.fistprojectcompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {


    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}