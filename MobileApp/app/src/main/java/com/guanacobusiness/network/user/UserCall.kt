package com.guanacobusiness.network.user

import com.guanacobusiness.network.RetrofitInstance

object UserCall {
    suspend fun getAllUser() : List<UserRequest>? {

        val call = RetrofitInstance.retrofit.create(UserService::class.java).getUsers()
        val users= call.body()
        val user = users?.users
        return user?.toMutableList()
    }
}