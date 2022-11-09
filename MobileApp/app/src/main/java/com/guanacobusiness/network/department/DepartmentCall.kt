package com.guanacobusiness.network.department

import com.guanacobusiness.model.department
import com.guanacobusiness.network.RetrofitInstance

object DepartmentCall {
    suspend fun getAllDeparment() : List<department>? {

        val call = RetrofitInstance.retrofit.create(DepartmentService::class.java).getDepartments()
        val departments = call.body()
        val department = departments?.departments
        return department?.toMutableList()
    }


}