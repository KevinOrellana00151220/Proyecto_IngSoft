package com.guanacobusiness.network.job


import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.job

data class JobResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("jobs") var jobs: List<job>,
)