package com.example.toylabs.infrastructure.persistence.repository.impl

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.domain.repository.BoardRepository
import com.example.toylabs.infrastructure.persistence.mapper.BoardMapper
import com.example.toylabs.infrastructure.persistence.repository.BoardJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BoardRepositoryImpl(
    val boardJpaRepository: BoardJpaRepository,
    val boardMapper: BoardMapper
) : BoardRepository {

    override fun fetchAllBoards(): List<Board> =
        boardJpaRepository.findAll().map(boardMapper::toBoard)

    override fun fetchBoardById(id: Long): Optional<Board> =
        boardJpaRepository.findById(id).map(boardMapper::toBoard)

}
