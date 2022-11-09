package com.guanacobusiness.network.worktype

import retrofit2.Response
import retrofit2.http.GET

interface WorktypeService {
    @GET("/worktypes")
    suspend fun getWorktypes(): Response<WorktypeResponse>

}