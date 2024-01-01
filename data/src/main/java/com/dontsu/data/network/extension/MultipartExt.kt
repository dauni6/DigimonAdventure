package com.dontsu.data.network.extension

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

fun Any.getMultipartBody(
    key: String,
    mediaType: String = "application/pdf"
): MultipartBody.Part {
    return when (this) {
        is String,
        is Int,
        is Double,
        is Long -> {
            MultipartBody.Part.createFormData(
                name = key,
                value = this.toString()
            )
        }
        is File -> {
            val requestBody = this.asRequestBody("${mediaType}; charset=utf-8".toMediaTypeOrNull())

            return MultipartBody.Part.createFormData(
                name = key,
                filename = this.name,
                body = requestBody
            )
        }
        else -> throw IllegalArgumentException("유효하지 않은 타입을 사용하였습니다. String, Int, Double, Long, File 타입만 사용할 수 있습니다.")
    }
}
