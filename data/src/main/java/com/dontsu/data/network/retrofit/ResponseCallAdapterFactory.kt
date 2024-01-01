package com.dontsu.data.network.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * A [CallAdapter.Factory] which supports suspend + [ApiResponse] as the return type
 *
 * Adding this to [Retrofit] will enable you to return [ApiResponse] from your service methods.
 *
 * ```kotlin
 * package com.dontsu.data.network.retrofit
 * import retrofit2.http.GET
 *
 * data class Digimon(val name: String)
 *
 * interface DigimonApi {
 *   @GET("/v1/digimon")
 *   suspend fun getUser(): ApiResponse<Digimon>
 *
 *   @GET("/error")
 *   suspend fun tryNetworkError(): ApiResponse<Digimon>
 * }
 * ```
 *
 * source based on https://github.com/Pluu/CustomCallAdapterSample/blob/master/ApiResultCallAdapter/src/main/java/com/pluu/retrofit/adapter/ResultCallAdapterFactory.kt
 */
class ResponseCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        val rawType = getRawType(returnType)

        if (returnType !is ParameterizedType) {
            val name = parseTypeName(returnType)
            throw IllegalArgumentException(
                "Return type must be parameterized as " +
                        "$name<Foo> or $name<out Foo>"
            )
        }

        return when (rawType) {
            Call::class.java -> apiResponseAdapter(returnType)
            else -> null
        }

    }

    private fun apiResponseAdapter(returnType: ParameterizedType) : CallAdapter<Type, out Call<out Any>>? {
        val wrapperType = getParameterUpperBound(0, returnType)

        return when (getRawType(wrapperType)) {
            ApiResponse::class.java -> {
                val bodyType = extractReturnType(wrapperType = wrapperType, returnType = returnType)
                ApiResponseCallAdapter(bodyType)
            }

            else -> null
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun extractReturnType(
        wrapperType: Type,
        returnType: ParameterizedType
    ): Type {
        if (wrapperType !is ParameterizedType) {
            val name = parseTypeName(returnType)
            throw IllegalArgumentException(
                "Return type must be parameterized as $name<ResponseBody>"
            )
        }
        return getParameterUpperBound(0, wrapperType)
    }

}

private fun parseTypeName(type: Type) =
    type.toString()
        .split(".")
        .last()