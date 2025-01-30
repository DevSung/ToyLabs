package com.example.toylabs.application.dto.auth.request

import com.example.toylabs.global.validation.annotation.ValidEmail
import com.example.toylabs.global.validation.annotation.ValidPassword
import jakarta.validation.constraints.NotBlank

data class SignUpRequest(
    @field:ValidEmail(message = "유효한 이메일 주소를 입력해주세요.")
    val email: String,

    @field:ValidPassword(message = "비밀번호는 8자 이상, 대소문자 및 특수문자를 각 1개 이상 포함해야 합니다.")
    val password: String,

    @field:NotBlank(message = "이름은 필수 입력 값입니다.")
    val name: String,

    @field:NotBlank(message = "닉네임은 필수 입력 값입니다.")
    val nickName: String
)