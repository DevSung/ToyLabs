package com.example.toylabs.global.exception

import com.example.toylabs.application.dto.common.ApiResponse
import com.example.toylabs.application.util.errorResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<ApiResponse> {
        log.error("CustomException occurred: ${e.message}", e)
        return errorResponse(e.httpStatus, e.message!!)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ApiResponse> {
        val firstErrorMessage = ex.bindingResult.fieldErrors.firstOrNull()?.defaultMessage ?: "Validation failed"
        log.error("MethodArgumentNotValidException occurred: $firstErrorMessage", ex)
        return errorResponse(HttpStatus.BAD_REQUEST, firstErrorMessage)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse> {
        log.error("Unexpected exception occurred: ${e.message}", e)
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.message ?: "알 수 없는 오류가 발생했습니다.")
    }

}