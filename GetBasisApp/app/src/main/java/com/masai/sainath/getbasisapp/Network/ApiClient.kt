package com.masai.sainath.getbasisapp.Network

import retrofit2.http.GET

interface ApiClient {

    @GET("fjaqJ")
    suspend fun getResponse() : String

}