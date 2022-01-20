package com.masai.sainath.getbasisapp.di

import com.masai.sainath.getbasisapp.Network.ApiClient
import com.masai.sainath.getbasisapp.Model.data.ResponseModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder

import com.google.gson.Gson
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object MovieModule {


    @Singleton
    @Provides
    suspend fun ProvidesApi(): ResponseModel {

        val gson = GsonBuilder()
            .setLenient()
            .create()


        val builder = Retrofit.Builder()
            .baseUrl("https://git.io/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        var response : String = builder.create(ApiClient::class.java).getResponse()

        var data: String = response.substring(1)

        val responseModel = Gson().fromJson(
            data,
            ResponseModel::class.java
        )

        return responseModel
    }
}
