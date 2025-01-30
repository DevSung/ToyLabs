package com.example.toylabs.application.service

import com.example.toylabs.application.dto.auth.request.LoginRequest
import com.example.toylabs.application.dto.auth.request.SignUpRequest
import com.example.toylabs.application.dto.auth.response.LoginResponse
import com.example.toylabs.application.dto.mapper.MemberDtoMapper
import com.example.toylabs.domain.service.AuthService
import com.example.toylabs.domain.service.MemberService
import org.springframework.stereotype.Service

@Service
class AuthApiService(
    private val memberService: MemberService,
    private val authService: AuthService,
    private val memberDtoMapper: MemberDtoMapper
) {

    fun signup(request: SignUpRequest) =
        memberService.signup(request)

    fun login(request: LoginRequest): LoginResponse =
        memberDtoMapper.toLoginResponse(authService.login(request))


}
