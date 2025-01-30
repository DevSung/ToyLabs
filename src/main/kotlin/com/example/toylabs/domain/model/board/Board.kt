package com.example.toylabs.domain.model.board

import java.time.LocalDateTime

data class Board(
    val id: Long,
    var title: String,
    var content: String,
    var writer: String,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
)
