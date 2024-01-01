package com.dontsu.data.exception

import java.io.IOException
import java.net.SocketTimeoutException

class EmptyLocalDataException(message: String? = "There is no data."): Exception(message)

class EmptyResponseBodyException(message: String? = "There is no data.", ) : Exception(message)

/* Network */
/**
 * When the internet connection is poor or disconnected.
 * */
class NetworkBadConnectionException(
    message: String? = "The network connection is not good. Please check the network status.",
): IOException(message)

/**
 * When the URL is incorrect, causing the API request resource not to be found, (404 Page Not Found : HttpURLConnection.HTTP_NOT_FOUND)
 * when the transmitted parameter values are too long. (414 Request-URI Too Large : HttpURLConnection.HTTP_REQ_TOO_LONG)
 *
 * */
class NetworkBadUrlException(
    message: String? = "The network request address is incorrect.",
): IOException(message)

/**
 * When the network request time exceeds the timeout().
 * */
class NetworkSocketTimeoutException(
    message: String? = "There is a delay in the network connection. Please try again in a moment.",
): SocketTimeoutException(message)