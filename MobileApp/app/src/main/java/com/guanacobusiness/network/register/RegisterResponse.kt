package com.guanacobusiness.network.register

import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.user

data class RegisterResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("user")
    val user: user
)
