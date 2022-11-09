package com.guanacobusiness.network.user

import com.google.gson.annotations.SerializedName

data class  UserResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("users") var users: List<UserRequest>,
)