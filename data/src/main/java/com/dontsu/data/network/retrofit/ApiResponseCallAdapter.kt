package com.dontsu.data.network.retrofit

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

/**
 * source based on https://github.com/Pluu/CustomCallAdapterSample/blob/master/ApiResultCallAdapter/src/main/java/com/pluu/retrofit/adapter/ApiResultCallAdapter.kt
 * */
class ApiResponseCallAdapter<R>(
    private val successType: Type
) : CallAdapter<R, Call<ApiResponse<R>>> {
    override fun adapt(call: Call<R>): Call<ApiResponse<R>> = ApiResponseCall(call, successType)
    override fun responseType(): Type = successType
}

/**
 * The ApiResponse object is returned based on the success or failure of the response.
 * */
private class ApiResponseCall<R>(
    private val delegate: Call<R>,
    private val successType: Type
): Call<ApiResponse<R>> {

    override fun enqueue(callback: Callback<ApiResponse<R>>) = delegate.enqueue(
        object : Callback<R> {

            override fun onResponse(call: Call<R>, response: Response<R>) {
                callback.onResponse(this@ApiResponseCall, Response.success(response.toApiResponse()))
            }

            private fun Response<R>.toApiResponse(): ApiResponse<R> {
                // Http error response (4xx - 5xx)
                if (!isSuccessful) {
                    val errorBody = errorBody()!!.string()
                    return ApiResponse.Failure.HttpError(
                        statusCode = code(),
                        message = message(),
                        body = errorBody
                    )
                }

                // Http success response with body (200 success)
                body()?.let { body ->
                    return ApiResponse.successOf(body)
                }

                // if we defined Unit as success type it means we expected no response body
                // e.g. in case of 204 No Content
                return if (successType == Unit::class.java) {
                    @Suppress("UNCHECKED_CAST")
                    ApiResponse.successOf(Unit as R)
                } else {
                    ApiResponse.Failure.UnknownApiError(
                        IllegalStateException(
                            "Response code is ${code()} but body is null.\n" +
                                    "If you expect response body to be null then define your API method as returning Unit:\n" +
                                    "@POST fun postSomething(): ApiResult<Unit>"
                        )
                    )
                }

            }

            override fun onFailure(call: Call<R>, throwable: Throwable) {
                val error = if (throwable is IOException) {
                    ApiResponse.Failure.NetworkError(throwable)
                } else {
                    ApiResponse.Failure.UnknownApiError(throwable)
                }
                callback.onResponse(this@ApiResponseCall, Response.success(error))
            }

        }
    )

    override fun clone(): Call<ApiResponse<R>> = ApiResponseCall(delegate.clone(), successType)

    override fun execute(): Response<ApiResponse<R>> =
        throw UnsupportedOperationException("This adapter does not support sync execution")

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

}