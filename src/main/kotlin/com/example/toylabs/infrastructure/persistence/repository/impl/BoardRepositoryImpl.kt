package com.example.toylabs.infrastructure.persistence.repository.impl

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.domain.repository.BoardRepository
import com.example.toylabs.infrastructure.persistence.enitty.board.BoardEntity
import com.example.toylabs.infrastructure.persistence.mapper.board.BoardMapper
import org.springframework.stereotype.Repository

@Repository
class BoardRepositoryImpl(
    val boardJpaRepository: BoardJpaRepository,
    val boardMapper: BoardMapper
) : BoardRepository {

    override fun fetchAllBoards(): List<Board> {
        val entities: List<BoardEntity> = boardJpaRepository.findAll()
        return entities.map { boardMapper.toModel(it) }
    }

    override fun fetchBoardById(id: Long): Board {
        return boardMapper.toModel(boardJpaRepository.findById(id).get())
    }

}
