package com.guanacobusiness.dto.Login

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("/login")
    suspend fun login(@Body credentials: LoginRequest ): Response<LoginResponse>

}