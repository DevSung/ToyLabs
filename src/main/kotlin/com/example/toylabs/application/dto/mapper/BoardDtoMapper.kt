package com.example.toylabs.application.dto.mapper

import com.example.toylabs.application.dto.board.BoardResponse
import com.example.toylabs.domain.model.board.Board
import org.springframework.stereotype.Component

@Component
class BoardDtoMapper {
    fun toBoardResponse(board: Board): BoardResponse {
        return BoardResponse(
            id = board.id,
            title = board.title,
            content = board.content,
            writer = board.writer,
            createdAt = board.createdAt
        )
    }
}
