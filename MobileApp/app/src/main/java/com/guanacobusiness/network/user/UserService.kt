package com.guanacobusiness.network.user

import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getUsers(): Response<UserResponse>
}