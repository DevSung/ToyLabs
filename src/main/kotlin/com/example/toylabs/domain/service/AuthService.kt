package com.example.toylabs.domain.service

import com.example.toylabs.application.dto.auth.request.LoginRequest
import com.example.toylabs.global.exception.loginFailed
import com.example.toylabs.global.exception.passwordNotMatch
import com.example.toylabs.global.security.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val memberService: MemberService,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun getMemberByEmail(email: String) = memberService.getMemberByEmail(email)

    @Transactional(readOnly = true)
    fun login(request: LoginRequest): String = runCatching {
        val member = getMemberByEmail(request.email)

        if (!passwordEncoder.matches(request.password, member.password)) {
            throw passwordNotMatch("비밀번호가 일치하지 않습니다.")
        }
        jwtTokenProvider.createToken(member, listOf("ROLE_USER"))
    }.getOrElse {
        throw loginFailed("로그인에 실패하였습니다.")
    }

}
