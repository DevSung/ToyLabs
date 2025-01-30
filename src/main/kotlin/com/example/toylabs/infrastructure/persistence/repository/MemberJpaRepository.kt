package com.example.toylabs.infrastructure.persistence.repository

import com.example.toylabs.infrastructure.persistence.enitty.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberJpaRepository : JpaRepository<MemberEntity, Long> {
    fun findByEmail(email: String): Optional<MemberEntity>
}