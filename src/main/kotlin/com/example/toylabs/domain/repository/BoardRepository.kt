package com.example.toylabs.domain.repository

import com.example.toylabs.domain.model.board.Board
import java.util.*

interface BoardRepository {
    fun fetchAllBoards(): List<Board>
    fun fetchBoardById(id: Long): Optional<Board>
}
