package com.guanacobusiness.getsetdata

object GetSetJob {
    private var jobImage = ""
    private var jobTitle = ""
    private var jobDescription = ""
    private var jobSchedule = ""
    private var salary = ""
    private var deparmentId = ""
    private var workTypeId = ""
    private var userId = ""

    fun getJobImage(): String {
        return jobImage
    }

    fun setJobImage(jobImage: String) {
        this.jobImage = jobImage
    }

    fun setjobTitle(jobTitle: String) {
        this.jobTitle = jobTitle
    }

    fun getjobTitle(): String {
        return jobTitle
    }

    fun setjobDescription(jobDescription: String) {
        this.jobDescription = jobDescription
    }

    fun getjobDescription(): String {
        return jobDescription
    }

    fun setjobSchedule(jobSchedule: String) {
        this.jobSchedule = jobSchedule
    }

    fun getjobSchedule(): String {
        return jobSchedule
    }

    fun setsalary(salary: String) {
        this.salary = salary
    }

    fun getsalary(): String {
        return salary
    }

    fun setdeparmentId(deparmentId: String) {
        this.deparmentId = deparmentId
    }

    fun getdeparmentId(): String {
        return deparmentId
    }

    fun setworkTypeId(workTypeId: String) {
        this.workTypeId = workTypeId
    }

    fun getworkTypeId(): String {
        return workTypeId
    }

    fun setuserId(userId: String) {
        this.userId = userId
    }

    fun getuserId(): String {
        return userId
    }
}