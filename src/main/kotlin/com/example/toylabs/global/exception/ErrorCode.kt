package com.example.toylabs.global.exception

import org.springframework.http.HttpStatus

enum class CustomError(
    private val httpStatus: HttpStatus,
    private val defaultMessage: String
) {
    NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "Password does not match"),
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "Login failed");

    fun toException(customMessage: String? = null): CustomException {
        return CustomException(
            httpStatus,
            customMessage ?: defaultMessage
        )
    }
}