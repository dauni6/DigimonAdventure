package com.dontsu.data.network.util

import com.dontsu.data.network.extension.getMultipartBody
import com.dontsu.data.network.extension.getRequestBody
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun getFieldMapOf(vararg pairs: Pair<String, Any?>): Map<String, String> {
    val map = hashMapOf<String, String>()

    for ((key, value) in pairs) {
        when (value) {
            is String,
            is Int,
            is Double,
            is Long -> map[key] = value.toString()
            else -> throw IllegalArgumentException(
                "유효하지 않은 타입을 사용하였습니다. String, Int, Double, Long 타입만 사용할 수 있습니다."
            )
        }
    }

    return map
}

/**
 *
 * ```
 *     @WorkerThread
 *     suspend fun uploadWebPrint(
 *         printId: String,
 *         documentTitle: String,
 *         doucmentInfo: String
 *     ): WebPrint {
 *         val multipartMap = getMultipartMapOf(
 *             "printId" to printId,
 *             "documentTitle" to documentTitle,
 *             "doucmentInfo" to doucmentInfo,
 *         )
 *
 *         return api.uploadWebPrint(multipartMap).getOrThrow().toWebPrint()
 *     }
 * ```
 *
 * File을 같이 사용하고 싶다면 [getMutipartListOf]를 사용하세요.
 * */
fun getRequestBodyMapOf(vararg pairs: Pair<String, Any?>): HashMap<String, RequestBody> {
    val map = HashMap<String, RequestBody>()

    for ((key, value) in pairs) {
        when (value) {
            is String,
            is Int,
            is Double,
            is Long -> map[key] = value.getRequestBody()
            else -> throw IllegalArgumentException(
                "유효하지 않은 타입을 사용하였습니다. String, Int, Double, Long 타입만 사용할 수 있습니다."
            )
        }
    }

    return map
}

/**
 *
 * ```
 *     @WorkerThread
 *     suspend fun uploadWebPrint(
 *         printId: String,
 *         documentTitle: String,
 *         doucmentInfo: String,
 *         file: File
 *     ): WebPrint {
 *         val multipartList = getMutipartListOf(
 *             "printId" to printId,
 *             "documentTitle" to documentTitle,
 *             "doucmentInfo" to doucmentInfo,
 *             "file" to file
 *         )
 *
 *         return api.uploadWebPrint(multipartList).getOrThrow().toWebPrint()
 *     }
 * ```
 * */
fun getMutipartListOf(vararg pairs: Pair<String, Any?>): List<MultipartBody.Part> {
    val list = arrayListOf<MultipartBody.Part>()

    for ((key, value) in pairs) {
        when (value) {
            is String,
            is Int,
            is Double,
            is Long,
            is File -> list.add(value.getMultipartBody(key))
            else -> throw IllegalArgumentException(
                "유효하지 않은 타입을 사용하였습니다. String, Int, Double, Long, File 타입만 사용할 수 있습니다."
            )
        }
    }

    return list
}