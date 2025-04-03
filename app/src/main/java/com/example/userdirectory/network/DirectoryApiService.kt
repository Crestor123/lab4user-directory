package com.example.userdirectory.network

import com.example.userdirectory.model.UserData
import com.example.userdirectory.model.UserDataResults
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/api/"
private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

object DirectoryApi {
    val retrofitService : DirectoryApiService by lazy {
        retrofit.create(DirectoryApiService::class.java)
    }
}

interface DirectoryApiService {
    @GET("?results=20")
    suspend fun getUserData() : UserDataResults
}