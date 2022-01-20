package com.masai.sainath.getbasisapp.repo

import com.masai.sainath.getbasisapp.di.MovieModule
import com.masai.sainath.getbasisapp.Model.data.ResponseModel
import com.masai.sainath.getbasisapp.Model.Resource
import com.masai.sainath.getbasisapp.Model.ResponseHandler
import javax.inject.Inject

open class CardRepo @Inject constructor() {

    var responseHandler = ResponseHandler()

    suspend fun getData(): Resource<ResponseModel> {
        val data = MovieModule.ProvidesApi()
        return try {
            responseHandler.handleSuccess(data)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}