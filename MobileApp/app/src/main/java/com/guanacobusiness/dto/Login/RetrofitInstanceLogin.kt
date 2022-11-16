package com.guanacobusiness.dto.Login


import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://188.166.37.93:9000/"
object RetrofitInstanceLogin {
    private val interceptorLogging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private var token = ""
    private var user = ""

    fun setUser(user: String) {
        this.user = user
    }
    fun getUser(): String {
        return user
    }

    fun setToken(token: String) {
        this.token = token
    }

    fun getToken(): String {
        return token
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): LoginService{
        return retrofit.create(LoginService::class.java)
    }
}