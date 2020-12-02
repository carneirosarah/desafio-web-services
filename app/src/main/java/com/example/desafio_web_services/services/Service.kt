package com.example.desafio_web_services.services

import com.example.desafio_web_services.domain.Res
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val url = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val repository: Repository = retrofit.create(Repository::class.java)

interface Repository {

    @GET("comics")
    suspend fun getResults(
            @Query("offset") p1:Int,
            @Query("limit") p2:Int,
            @Query("ts") p3:String,
            @Query("apikey") p4:String,
            @Query("hash") p5:String
    ): Res
}