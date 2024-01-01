package com.dontsu.data.network.retrofit

import com.dontsu.data.exception.NetworkBadConnectionException
import com.dontsu.data.exception.NetworkSocketTimeoutException
import java.net.SocketTimeoutException

/**
 * Response Object for API Requests
 *
 * source based on https://github.com/Pluu/CustomCallAdapterSample/blob/master/ApiResultCallAdapter/src/main/java/com/pluu/retrofit/adapter/ApiResult.kt
 * */
sealed interface ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>

    sealed interface Failure : ApiResponse<Nothing> {
        data class HttpError(val statusCode: Int, val message: String, val body: String) : Failure

        data class NetworkError(val throwable: Throwable) : Failure

        data class UnknownApiError(val throwable: Throwable) : Failure

        fun safeThrowable(): Throwable = when (this) {

            is HttpError -> {
                IllegalStateException(
                    "error code : $statusCode\n" +
                    "message : $message\n" +
                    "body : $body"
                )
            }

            is NetworkError -> {
                if (throwable is SocketTimeoutException) {
                    NetworkSocketTimeoutException()
                } else {
//                    if (!isNetworkConnected(MonkeyApplication.getContext())) {
//                        NetworkBadConnectionException()
//                    } else {
//                        NetworkBadUrlException()
//                    }
                    NetworkBadConnectionException()
                }

            }
            is UnknownApiError -> throwable
        }

    }

    fun isSuccess(): Boolean = this is Success

    fun isFailure(): Boolean = this is Failure

    fun getOrThrow(): T {
        throwOnFailure()
        return (this as Success).data
    }

    fun getOrNull(): T? =
        when (this) {
            is Success -> data
            else -> null
        }

    fun failureOrThrow(): Failure {
        throwOnSuccess()
        return this as Failure
    }

    fun exceptionOrNull(): Throwable? =
        when (this) {
            is Failure -> safeThrowable()
            else -> null
        }

    companion object {
        fun <R> successOf(result: R): ApiResponse<R> = Success(result)
    }

}

fun ApiResponse<*>.throwOnFailure() {
    if (this is ApiResponse.Failure) throw safeThrowable()
}

fun ApiResponse<*>.throwOnSuccess() {
    if (this is ApiResponse.Success) throw IllegalStateException("Cannot be called under Success conditions.")
}

inline fun <T> ApiResponse<T>.onSuccess(
    action: (value: T) -> Unit
): ApiResponse<T> {
    if (isSuccess()) action(getOrThrow())
    return this
}

inline fun <T> ApiResponse<T>.onFailure(
    action: (error: ApiResponse.Failure) -> Unit
): ApiResponse<T> {
    if (isFailure()) action(failureOrThrow())
    return this
}