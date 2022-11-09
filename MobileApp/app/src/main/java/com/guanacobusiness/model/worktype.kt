package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class worktype(
    @SerializedName("_id")val id: String,
    @SerializedName("worktype")val worktype: String
)
