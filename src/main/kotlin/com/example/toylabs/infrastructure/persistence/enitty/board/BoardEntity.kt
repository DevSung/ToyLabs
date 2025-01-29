package com.example.toylabs.infrastructure.persistence.enitty.board

import com.example.toylabs.infrastructure.persistence.enitty.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "board", schema = "toy_labs")
class BoardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "content", nullable = false)
    var content: String,
    @Column(name = "writer", nullable = false)
    val writer: String,
) : BaseEntity()