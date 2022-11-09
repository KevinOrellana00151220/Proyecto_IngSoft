package com.guanacobusiness.network.job

import com.google.gson.annotations.SerializedName

data class JobRequest(
    @SerializedName("title")val title: String,
    @SerializedName("logoimag")val imagen: String,
    @SerializedName("description")val description: String,
    @SerializedName("schedule")val schedule: String,
    @SerializedName("salary")val salary: Number,
    @SerializedName("worktype")val worktype: String,
    @SerializedName("department")val department: String,
    @SerializedName("workplace")val workplace: String,
    @SerializedName("employer")val employer: String,
    @SerializedName("requisites")val requisites: String

)