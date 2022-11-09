
package com.guanacobusiness.network.register

import com.guanacobusiness.model.user
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegisterService {
    @Headers("Content-Type: application/json")
    @POST("/register")
    suspend fun register(@Body data: user): Response<RegisterResponse>
}