package com.example.toylabs.application.util

import com.example.toylabs.application.dto.common.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun <T> T.toSuccessResponse(): ResponseEntity<ApiResponse> { // 기존 success()
    return ResponseEntity.ok(ApiResponse.success(this))
}

fun defaultSuccessResponse(): ResponseEntity<ApiResponse> { // 기존 defaultSuccess()
    return ResponseEntity.ok(ApiResponse.default())
}

fun errorResponse(code: HttpStatus, message: String): ResponseEntity<ApiResponse> { // 기존 error()
    return ResponseEntity.status(code).body(ApiResponse.error(code, message))
}