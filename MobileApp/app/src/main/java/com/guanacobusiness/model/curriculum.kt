package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class curriculum(
    @SerializedName("_id")val id: String,
    @SerializedName("email")val email: String,
    @SerializedName("fullname")val fullName: String,
    @SerializedName("gender")val gender: String,
    @SerializedName("address")val address: String,
    @SerializedName("phone")val phone: String,
    @SerializedName("worktype")val worktype: worktype,
    @SerializedName("experience")val experience: String,
    @SerializedName("education")val education: String,
    @SerializedName("abilities")val abilities: String,
    @SerializedName("languages")val languages: List<String>
)
