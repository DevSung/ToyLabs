package com.example.toylabs.domain.service

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.domain.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
    val boardRepository: BoardRepository
) {

    fun getAllBoards(): List<Board> =
        boardRepository.fetchAllBoards()

}
