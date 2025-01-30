package com.example.toylabs.domain.repository

import com.example.toylabs.domain.model.member.Member
import java.util.*

interface MemberRepository {
    fun saveMember(member: Member)
    fun findByEmail(email: String): Optional<Member>
}
