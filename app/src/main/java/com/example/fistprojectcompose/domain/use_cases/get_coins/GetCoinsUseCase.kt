package com.example.fistprojectcompose.domain.use_cases.get_coins

import com.example.fistprojectcompose.common.Resource
import com.example.fistprojectcompose.data.remote.dto.toCoin
import com.example.fistprojectcompose.domain.model.a.Coin
import com.example.fistprojectcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Sucess(coins))
        } catch (error: HttpException) {
            emit(Resource.Error(error.localizedMessage ?: "error error bizzz bizz"))
        } catch (error: IOException) {
            emit(Resource.Error("invalid connection"))
        }
    }
}