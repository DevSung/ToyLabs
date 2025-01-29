package com.example.toylabs.domain.model.board

import java.time.LocalDateTime

class Board(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
