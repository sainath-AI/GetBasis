package com.masai.sainath.getbasisapp.Model.data


import com.google.gson.annotations.SerializedName

open class ResponseModel(
    @SerializedName("data")
    val data: List<Data>
)