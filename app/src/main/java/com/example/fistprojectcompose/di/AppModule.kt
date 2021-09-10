package com.example.fistprojectcompose.di

import com.example.fistprojectcompose.common.Constants
import com.example.fistprojectcompose.data.remote.CoinPaprikaApi
import com.example.fistprojectcompose.data.repository.CoinRepositoryImp
import com.example.fistprojectcompose.domain.model.a.Coin
import com.example.fistprojectcompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun providerCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImp(api)
    }
}