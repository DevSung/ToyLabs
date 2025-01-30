package com.example.toylabs.application.controller

import com.example.toylabs.application.dto.auth.request.LoginRequest
import com.example.toylabs.application.dto.auth.request.SignUpRequest
import com.example.toylabs.application.dto.common.ApiResponse
import com.example.toylabs.application.service.AuthApiService
import com.example.toylabs.application.util.defaultSuccessResponse
import com.example.toylabs.application.util.toSuccessResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authApiService: AuthApiService
) {

    @PostMapping("/signup")
    fun signup(@Valid @RequestBody request: SignUpRequest): ResponseEntity<ApiResponse> {
        authApiService.signup(request)
        return defaultSuccessResponse()
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<ApiResponse> =
        authApiService.login(request).toSuccessResponse()

}