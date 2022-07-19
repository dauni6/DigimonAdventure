package com.dontsu.data.network

import com.dontsu.data.model.ContentResponse
import com.dontsu.data.model.DigimonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DigimonApi {

    @GET("api/v1/digimon")
    suspend fun getDigimonList(@Query("pageSize") pageSize: Int = 100): Response<List<ContentResponse>>

    @GET("search.php/{id}")
    suspend fun searchDigimon(@Path("id") id: String): Response<DigimonResponse>

}
