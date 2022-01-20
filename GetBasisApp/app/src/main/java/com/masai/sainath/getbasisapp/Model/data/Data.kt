package com.masai.sainath.getbasisapp.Model.data


import com.google.gson.annotations.SerializedName

open class Data(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String
)