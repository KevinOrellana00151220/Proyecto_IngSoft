package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class user(
    @SerializedName("username")val username: String,
    @SerializedName("email")val email: String,
    @SerializedName("fullname")val fullname: String,
    @SerializedName("password")val password: String,
    @SerializedName("imgurl")val imgurl: String,
    @SerializedName("profession")val profession: String ,
    @SerializedName("curriculum")val curriculum: String?
)
