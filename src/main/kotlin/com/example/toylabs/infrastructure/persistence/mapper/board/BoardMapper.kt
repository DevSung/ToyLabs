package com.example.toylabs.infrastructure.persistence.mapper.board

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.infrastructure.persistence.enitty.board.BoardEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface BoardMapper {
    fun toModel(board: BoardEntity): Board
    fun toEntity(board: Board): BoardEntity
}