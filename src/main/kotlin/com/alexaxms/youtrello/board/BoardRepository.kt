package com.alexaxms.youtrello.board

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository

interface BoardRepository : Repository<Board, String> {
    fun save(board: Board)
    fun findByTitle(title: String) : Board?
    fun findAll(pageable: Pageable) : Page<Board>
}
