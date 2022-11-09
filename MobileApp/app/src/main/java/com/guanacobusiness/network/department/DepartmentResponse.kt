package com.guanacobusiness.network.department

import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.department
import java.util.*

data class DepartmentResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("departments") var departments: List<department>,
)
