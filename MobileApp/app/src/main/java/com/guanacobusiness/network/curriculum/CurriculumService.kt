package com.guanacobusiness.network.curriculum

import com.guanacobusiness.model.curriculum

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CurriculumService {
    @GET("/curriculums")
    suspend fun getCurriculums(): Response<CurriculumResponse>

    @Headers("Content-Type: application/json")
    @POST("/curriculum")
    suspend fun createCurriculum(@Body information: curriculum): Response<curriculum>

}