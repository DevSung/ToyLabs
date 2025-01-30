package com.example.toylabs.global.exception

import org.springframework.http.HttpStatus

class CustomException(
    val httpStatus: HttpStatus,
    errorMessage: String
) : RuntimeException(errorMessage)


fun notFound(message: String? = null): CustomException =
    CustomError.NOT_FOUND.toException(message)

fun badRequest(message: String? = null): CustomException =
    CustomError.BAD_REQUEST.toException(message)

fun passwordNotMatch(message: String? = null): CustomException =
    CustomError.PASSWORD_NOT_MATCH.toException(message)

fun loginFailed(message: String? = null): CustomException =
    CustomError.LOGIN_FAILED.toException(message)