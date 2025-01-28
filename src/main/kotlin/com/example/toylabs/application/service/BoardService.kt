package com.example.toylabs.application.service

import com.example.toylabs.application.dto.board.BoardResponse
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class BoardService {


    fun getBoardList(): List<BoardResponse> {


        return emptyList()
    }

}