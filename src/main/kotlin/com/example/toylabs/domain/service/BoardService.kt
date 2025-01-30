package com.example.toylabs.domain.service

import com.example.toylabs.domain.model.board.Board
import com.example.toylabs.domain.repository.BoardRepository
import com.example.toylabs.global.exception.notFound
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    @Transactional(readOnly = true)
    fun getAllBoards(): List<Board> =
        boardRepository.fetchAllBoards()

    @Transactional(readOnly = true)
    fun getBoardById(boardId: Long): Board =
        boardRepository.fetchBoardById(boardId).orElseThrow { notFound("게시글이 존재하지 않습니다.") }


}
