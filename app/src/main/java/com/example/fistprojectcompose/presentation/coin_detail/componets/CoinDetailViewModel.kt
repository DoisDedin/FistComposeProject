package com.example.fistprojectcompose.presentation.coin_list.component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fistprojectcompose.common.Constants
import com.example.fistprojectcompose.common.Constants.COIN_ID
import com.example.fistprojectcompose.common.Resource
import com.example.fistprojectcompose.domain.use_cases.get_coins.GetCoinUseCase
import com.example.fistprojectcompose.domain.use_cases.get_coins.GetCoinsUseCase
import com.example.fistprojectcompose.presentation.coin_detail.componets.CoinDetailState
import com.example.fistprojectcompose.presentation.coin_list.components.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinId ->
            getCoin(coinId = coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Sucess -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "shit, here go again")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }
    }
}