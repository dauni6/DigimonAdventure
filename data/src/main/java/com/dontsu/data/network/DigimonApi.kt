package com.dontsu.data.network

import com.dontsu.data.model.DigimonListResponse
import com.dontsu.data.model.DigimonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DigimonApi {

    @GET("api/v1/digimon")
    suspend fun getDigimonList(@Query("pageSize") pageSize: Int = 100): Response<DigimonListResponse>

    @GET("api/v1/digimon")
    suspend fun searchDigimon(@Query("name") name: String): Response<DigimonListResponse>

}
