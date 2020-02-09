package com.alexaxms.youtrello.board.infrastructure.controller

import com.alexaxms.youtrello.board.BoardFacade
import com.alexaxms.youtrello.board.dto.BoardDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
internal class BoardController(val boardFacade: BoardFacade) {
    @GetMapping("/boards")
    fun findBoards(pageable: Pageable): Page<BoardDto>? {
        return boardFacade.findBoards(pageable)
    }

    @GetMapping("boards/{title}")
    fun getBoard(@PathVariable title: String): BoardDto? {
        return boardFacade.showBoardDetails(title)
    }
}