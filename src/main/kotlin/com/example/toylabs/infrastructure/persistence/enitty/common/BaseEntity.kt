package com.example.toylabs.infrastructure.persistence.enitty.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity(
    // 등록일
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null,

    // 수정일
    @LastModifiedDate
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
)
