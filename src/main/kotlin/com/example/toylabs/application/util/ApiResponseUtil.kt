package com.example.toylabs.application.util

import com.example.toylabs.application.dto.common.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun <T> T.success(): ResponseEntity<ApiResponse> {
    return ResponseEntity.ok(ApiResponse.success(this))
}

fun success(): ResponseEntity<ApiResponse> {
    return ResponseEntity.ok(ApiResponse.default())
}

fun error(code: HttpStatus, message: String): ResponseEntity<ApiResponse> {
    return ResponseEntity.status(code).body(ApiResponse.error(code, message))
}