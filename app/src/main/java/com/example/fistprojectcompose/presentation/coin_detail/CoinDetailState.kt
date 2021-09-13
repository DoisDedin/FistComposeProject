package com.example.fistprojectcompose.presentation.coin_detail

import com.example.fistprojectcompose.domain.model.a.Coin
import com.example.fistprojectcompose.domain.model.a.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)