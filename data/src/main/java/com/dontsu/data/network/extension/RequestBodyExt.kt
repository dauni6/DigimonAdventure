package com.dontsu.data.network.extension

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun Any.getRequestBody(): RequestBody {
    return when (this) {
        is String,
        is Int,
        is Double,
        is Long -> this.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        else -> throw IllegalArgumentException("유효하지 않은 타입을 사용하였습니다. String, Int, Double, Long 타입만 사용할 수 있습니다.")
    }
}
