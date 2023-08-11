package com.dontsu.data.exception

class EmptyLocalDataException(message: String? = ""): Exception(message)

class EmptyBodyException(message: String? = "") : Exception(message)

class NetworkFailureException(message: String? = "") : Exception(message)