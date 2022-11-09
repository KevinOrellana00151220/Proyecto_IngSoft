package com.guanacobusiness.network.worktype

import com.google.gson.annotations.SerializedName
import com.guanacobusiness.model.worktype

data class WorktypeResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("allWorktypes") var worktypes: List<worktype>
)