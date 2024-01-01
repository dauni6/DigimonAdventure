package com.dontsu.data.network

import com.dontsu.data.model.response.DigimonListResponse
import com.dontsu.data.model.response.DigimonResponse
import com.dontsu.data.network.retrofit.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DigimonApi {

    @GET("api/v1/digimon")
    suspend fun getDigimonList(@Query("pageSize") pageSize: Int = 100): ApiResponse<DigimonListResponse>

    @GET("api/v1/digimon")
    suspend fun getDigimonList(@Query("page") page: Int = 0, @Query("pageSize") pageSize: Int = 20): ApiResponse<DigimonListResponse>

    @GET("api/v1/digimon")
    suspend fun searchDigimon(@Query("name") name: String): ApiResponse<DigimonListResponse>

    @GET("api/v1/digimon/{id}")
    suspend fun getDigimon(@Path("id") id: Int): ApiResponse<DigimonResponse>

}
