package com.example.toylabs.application.controller

import com.example.toylabs.application.dto.common.ApiResponse
import com.example.toylabs.application.service.BoardService
import com.example.toylabs.application.util.ApiResponseUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/board")
class BoardController(
    private val boardService: BoardService // 의존성 주입
) {

    @GetMapping("/list")
    fun getBoardList(): ResponseEntity<ApiResponse> {
        val boardList = boardService.getBoardList()
        return ApiResponseUtil.ok(boardList)
    }
}