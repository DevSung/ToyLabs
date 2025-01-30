package com.example.toylabs.domain.service

import com.example.toylabs.application.dto.auth.request.SignUpRequest
import com.example.toylabs.domain.model.member.Member
import com.example.toylabs.domain.repository.MemberRepository
import com.example.toylabs.global.exception.badRequest
import com.example.toylabs.global.exception.notFound
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun signup(request: SignUpRequest) {
        isExistEmail(request.email).let {
            if (it) throw badRequest("이미 존재하는 이메일입니다.")
        }
        memberRepository.saveMember(
            Member.create(
                request.copy(password = passwordEncoder.encode(request.password))
            )
        )
    }

    @Transactional(readOnly = true)
    fun getMemberByEmail(email: String): Member =
        memberRepository.findByEmail(email).orElseThrow { notFound("회원정보가 없습니다.") }

    fun isExistEmail(email: String): Boolean = memberRepository.findByEmail(email).isPresent
}