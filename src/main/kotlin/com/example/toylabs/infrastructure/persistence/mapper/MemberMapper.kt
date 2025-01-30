package com.example.toylabs.infrastructure.persistence.mapper

import com.example.toylabs.domain.model.member.Member
import com.example.toylabs.infrastructure.persistence.enitty.member.MemberEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MemberMapper {
    fun toMemberEntity(member: Member): MemberEntity
    fun toMember(member: MemberEntity): Member
}