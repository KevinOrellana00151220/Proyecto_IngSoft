package com.guanacobusiness.network.job

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface JobService {

    @Headers("Content-Type: application/json")
    @POST("/job")
    suspend fun postJob(@Body information: JobRequest): Response<JobPostResponse>


    @GET("/jobs")
    suspend fun getJobs(): Response<JobResponse>

}