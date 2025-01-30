package com.example.toylabs.application.dto.board.response

import java.time.LocalDateTime

data class BoardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,
    val createdAt: LocalDateTime
)
