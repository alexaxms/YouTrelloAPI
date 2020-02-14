package com.alexaxms.youtrello.board

import com.alexaxms.youtrello.board.dto.BoardDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


class BoardFacade(private val boardCreator: BoardCreator, private val boardRepository: BoardRepository) {
    fun add(dto: BoardDto) {
        val board = dto.let { boardCreator.create(it) }
        boardRepository.save(board)
    }

    fun showBoardDetails(title: String): BoardDto? {
        return boardRepository.findByTitle(title)?.dto()
    }

    fun findBoards(pageable: Pageable): Page<BoardDto>? {
        return boardRepository.findAll(pageable)
                .map(Board::dto)
    }

}
