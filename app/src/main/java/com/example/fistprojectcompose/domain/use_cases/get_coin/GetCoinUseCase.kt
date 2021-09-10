package com.example.fistprojectcompose.domain.use_cases.get_coins

import com.example.fistprojectcompose.common.Resource
import com.example.fistprojectcompose.data.remote.dto.toCoin
import com.example.fistprojectcompose.data.remote.dto.toCoinDetail
import com.example.fistprojectcompose.domain.model.a.Coin
import com.example.fistprojectcompose.domain.model.a.CoinDetail
import com.example.fistprojectcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Sucess(coin))
        } catch (error: HttpException) {
            emit(Resource.Error(error.localizedMessage ?: "error error bizzz bizz"))
        } catch (error: IOException) {
            emit(Resource.Error("invalid connection"))
        }
    }
}