package com.guanacobusiness.getsetdata

object GetSetUser {

    private var user = ""
    private var username = ""
    private var password = ""
    private var email = ""
    private var fullName = ""
    private var imgurl = ""
    private var profession = ""
    private var curriculum = ""

    fun setUser(user: String) {
        this.user = user
    }
    fun getUser(): String {
        return user
    }

    fun setUsername(user: String) {
        this.username = user
    }
    fun getUsername(): String {
        return username
    }

    fun setPassword(pass: String) {
        this.password = pass
    }
    fun getPassword(): String {
        return password
    }

    fun setEmail(email: String) {
        this.email = email
    }
    fun getEmail(): String {
        return email
    }

    fun setFullName(fullName: String) {
        this.fullName = fullName
    }
    fun getFullName(): String {
        return fullName
    }

    fun setImgurl(imgurl: String) {
        this.imgurl = imgurl
    }
    fun getImgurl(): String {
        return imgurl
    }

    fun setProfession(profession: String) {
        this.profession = profession
    }
    fun getProfession(): String {
        return profession
    }

    fun setCurriculum(curriculum: String) {
        this.curriculum = curriculum
    }
    fun getCurriculum(): String {
        return curriculum
    }

}