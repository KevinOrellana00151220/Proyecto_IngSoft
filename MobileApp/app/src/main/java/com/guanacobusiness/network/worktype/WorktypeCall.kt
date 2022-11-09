package com.guanacobusiness.network.worktype

import com.guanacobusiness.model.worktype
import com.guanacobusiness.network.RetrofitInstance

object WorktypeCall {
    suspend fun getAllWorktypes() : List<worktype>? {

        val call = RetrofitInstance.retrofit.create(WorktypeService::class.java).getWorktypes()
        val worktypes = call.body()
        val worktype = worktypes?.worktypes
        return worktype?.toMutableList()
    }


}