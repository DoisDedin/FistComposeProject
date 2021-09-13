package com.example.fistprojectcompose.presentation.coin_list

import com.example.fistprojectcompose.domain.model.a.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
        )