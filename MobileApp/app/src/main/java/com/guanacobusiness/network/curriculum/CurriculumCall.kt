package com.guanacobusiness.network.curriculum

import com.guanacobusiness.model.curriculum
import com.guanacobusiness.network.RetrofitInstance


object CurriculumCall {
    suspend fun getAllCurriculum() : List<curriculum>? {

        val call = RetrofitInstance.retrofit.create(CurriculumService::class.java).getCurriculums()
        val curriculums = call.body()
        val curriculum = curriculums?.curriculums
        return curriculum?.toMutableList()
    }


}