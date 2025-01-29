package com.example.toylabs.domain.exception

import org.springframework.http.HttpStatus

sealed class CustomException(
    val httpStatus: HttpStatus,
    errorMessage: String
) : RuntimeException(errorMessage) {

    class NotFoundException(errorMessage: String) : CustomException(HttpStatus.NOT_FOUND, errorMessage)

    class BadRequestException(errorMessage: String) : CustomException(HttpStatus.BAD_REQUEST, errorMessage)
}

fun notFound(message: String): CustomException = CustomException.NotFoundException(message)
fun badRequest(message: String): CustomException = CustomException.BadRequestException(message)