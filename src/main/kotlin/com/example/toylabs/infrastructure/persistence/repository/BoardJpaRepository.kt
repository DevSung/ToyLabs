package com.example.toylabs.infrastructure.persistence.repository

import com.example.toylabs.infrastructure.persistence.enitty.board.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardEntity, Long> {

}