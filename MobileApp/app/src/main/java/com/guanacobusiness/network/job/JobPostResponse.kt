package com.guanacobusiness.network.job

import com.google.gson.annotations.SerializedName

data class JobPostResponse(
    @SerializedName("message") var message: String,
    @SerializedName("job") var job: JobRequest
)