package com.example.toylabs.domain.model.member

import com.example.toylabs.application.dto.auth.request.SignUpRequest

data class Member(
    val id: Long?,
    val email: String,
    var password: String,
    var name: String,
    var nickName: String
) {
    companion object {
        fun create(signUpRequest: SignUpRequest): Member {
            return Member(null, signUpRequest.email, signUpRequest.password, signUpRequest.name, signUpRequest.nickName)
        }
    }
}