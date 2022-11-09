package com.guanacobusiness.network.department

import com.guanacobusiness.network.department.DepartmentResponse
import retrofit2.Response
import retrofit2.http.GET

interface DepartmentService {
    @GET("/departments")
    suspend fun getDepartments(): Response<DepartmentResponse>

}