package com.dontsu.data.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class DigimonInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val newUrl: HttpUrl = originalRequest.url.newBuilder().build()
        val newRequest: Request = originalRequest.newBuilder()
            .addHeader("Connection", "Keep-Alive")
            .addHeader("Content-Type", "application/json")
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}
