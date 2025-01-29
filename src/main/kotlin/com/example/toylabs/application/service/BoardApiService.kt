package com.example.toylabs.application.service

import com.example.toylabs.application.dto.board.BoardResponse
import com.example.toylabs.application.dto.mapper.BoardDtoMapper
import com.example.toylabs.domain.service.BoardService
import org.springframework.stereotype.Service

@Service
class BoardApiService(
    private val boardService: BoardService,
    private val boardDtoMapper: BoardDtoMapper
) {

    /**
     * 게시판 목록 조회
     */
    fun getAllBoardResponses(): List<BoardResponse> =
        boardService.getAllBoards().map(boardDtoMapper::toBoardResponse)


}