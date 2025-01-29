package com.example.toylabs.infrastructure.persistence.repository.impl

import com.example.toylabs.infrastructure.persistence.enitty.board.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardEntity, Long> {

}