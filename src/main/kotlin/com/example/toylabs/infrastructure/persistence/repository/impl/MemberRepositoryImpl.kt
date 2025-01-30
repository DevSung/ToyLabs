package com.example.toylabs.infrastructure.persistence.repository.impl

import com.example.toylabs.domain.model.member.Member
import com.example.toylabs.domain.repository.MemberRepository
import com.example.toylabs.infrastructure.persistence.mapper.MemberMapper
import com.example.toylabs.infrastructure.persistence.repository.MemberJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MemberRepositoryImpl(
    val memberJpaRepository: MemberJpaRepository,
    val memberMapper: MemberMapper
) : MemberRepository {

    override fun saveMember(member: Member) {
        memberJpaRepository.save(memberMapper.toMemberEntity(member))
    }

    override fun findByEmail(email: String): Optional<Member> {
        val memberEntity = memberJpaRepository.findByEmail(email)
        return memberEntity.map { memberMapper.toMember(it) }
    }


}