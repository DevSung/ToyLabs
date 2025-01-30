package com.example.toylabs.infrastructure.persistence.mapper

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.infrastructure.persistence.enitty.board.BoardEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface BoardMapper {
    fun toBoard(board: BoardEntity): Board
    fun toBoardEntity(board: Board): BoardEntity
}