package com.guanacobusiness.network.user

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("_id")val id: String,
    @SerializedName("username")val username: String,
    @SerializedName("email")val email: String,
    @SerializedName("fullname")val fullname: String,
    @SerializedName("imgurl")val imgurl: String
)