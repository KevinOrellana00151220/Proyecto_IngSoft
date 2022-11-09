package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class inscription(
    @SerializedName("_id")val id: String,
    @SerializedName("job")val job: job,
    @SerializedName("applicant")val applicant: user,
    @SerializedName("employer")val employer: user
)
