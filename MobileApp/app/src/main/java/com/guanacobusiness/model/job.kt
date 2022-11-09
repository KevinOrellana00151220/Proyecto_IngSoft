package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class job(
    @SerializedName("title")val title: String,
    @SerializedName("logoimag")val imagen: String,
    @SerializedName("description")val description: String,
    @SerializedName("schedule")val schedule: String,
    @SerializedName("salary")val salary: Number,
    @SerializedName("worktype")val worktype: worktype,
    @SerializedName("department")val department: department,
    @SerializedName("workplace")val workplace: String,
    @SerializedName("employer")val employer: user,
    @SerializedName("requisites")val requisites: String
)
