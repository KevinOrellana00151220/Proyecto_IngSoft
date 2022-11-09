package com.guanacobusiness.model

import com.google.gson.annotations.SerializedName

data class department(
  @SerializedName("_id")val id: String,
  @SerializedName("department")val department: String
)
