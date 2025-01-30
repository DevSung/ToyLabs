package com.example.toylabs.application.dto.mapper

import com.example.toylabs.application.dto.auth.response.LoginResponse
import org.springframework.stereotype.Component

@Component
class MemberDtoMapper {
    fun toLoginResponse(token: String): LoginResponse {
        return LoginResponse(
            token
        )
    }
}
