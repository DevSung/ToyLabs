package com.example.toylabs.infrastructure.persistence.enitty.member

import com.example.toylabs.infrastructure.persistence.enitty.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "member", schema = "toy_labs")
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "email", nullable = false)
    var email: String,
    @Column(name = "password", nullable = false)
    var password: String,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "nick_name")
    var nickName: String
) : BaseEntity()