package com.example.toylabs.domain.exception

import com.example.toylabs.application.dto.common.ApiResponse
import com.example.toylabs.application.util.error
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<ApiResponse> =
        error(e.httpStatus, e.message!!)


    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse> =
        error(HttpStatus.INTERNAL_SERVER_ERROR, e.message ?: "알 수 없는 오류가 발생했습니다.")

}