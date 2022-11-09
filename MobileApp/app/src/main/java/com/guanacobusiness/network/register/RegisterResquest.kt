package com.guanacobusiness.network.register

import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.curriculum
import com.guanacobusiness.model.worktype

data class RegisterRequest(
    @SerializedName("username")val username: String,
    @SerializedName("email")val email: String,
    @SerializedName("fullname")val fullname: String,
    @SerializedName("password")val password: String,
    @SerializedName("imgurl")val profileImg: String,
    @SerializedName("profession")val profession: worktype?,
    @SerializedName("curriculum")val curriculum: curriculum?
)