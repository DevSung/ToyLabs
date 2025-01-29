package com.example.toylabs.domain.repository

import com.example.toylabs.domain.model.board.Board
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository {
    fun fetchAllBoards(): List<Board>
    fun fetchBoardById(id: Long): Board
}
