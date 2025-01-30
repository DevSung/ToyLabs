package com.example.toylabs.application.controller

import com.example.toylabs.application.dto.common.ApiResponse
import com.example.toylabs.application.service.BoardApiService
import com.example.toylabs.application.util.toSuccessResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/board")
class BoardController(
    private val boardService: BoardApiService
) {

    /**
     * 게시판 목록 조회
     */
    @GetMapping("/list")
    fun getBoardList(): ResponseEntity<ApiResponse> =
        boardService.getAllBoardResponses().toSuccessResponse()

    /**
     * 게시판 상세 조회
     */
    @GetMapping("{boardId}")
    fun getBoardDetail(@PathVariable boardId: Long): ResponseEntity<ApiResponse> =
        boardService.getBoardDetail(boardId).toSuccessResponse()

}