package com.dontsu.data.network

import com.dontsu.data.model.reponse.DigimonListResponse
import com.dontsu.data.model.reponse.DigimonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DigimonApi {

    @GET("api/v1/digimon")
    suspend fun getDigimonList(@Query("pageSize") pageSize: Int = 100): Response<DigimonListResponse>

    @GET("api/v1/digimon")
    suspend fun searchDigimon(@Query("name") name: String): Response<DigimonListResponse>

    @GET("api/v1/digimon/{id}")
    suspend fun getDigimon(@Path("id") id: Int): Response<DigimonResponse>

}
