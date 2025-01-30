package com.example.toylabs.application.dto.auth.request

import com.example.toylabs.global.validation.annotation.ValidEmail
import jakarta.validation.constraints.NotBlank

class LoginRequest(
    @field:ValidEmail
    val email: String,
    @field:NotBlank
    val password: String
)
