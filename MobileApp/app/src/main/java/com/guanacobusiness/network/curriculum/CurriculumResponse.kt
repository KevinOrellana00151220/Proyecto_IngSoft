package com.guanacobusiness.network.curriculum

import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.curriculum

data class CurriculumResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("curriculums") var curriculums: List<curriculum>,
)
