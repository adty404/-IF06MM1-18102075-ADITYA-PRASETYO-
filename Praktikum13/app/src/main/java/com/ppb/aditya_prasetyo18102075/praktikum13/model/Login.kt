package com.ppb.aditya_prasetyo18102075.praktikum13.model

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("message")
    var message: String? = null
)