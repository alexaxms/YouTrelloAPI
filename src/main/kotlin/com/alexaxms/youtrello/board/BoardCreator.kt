package com.alexaxms.youtrello.board

import com.alexaxms.youtrello.board.dto.BoardDto

class BoardCreator {
    fun create(dto: BoardDto): Board {
        return Board(
                title = dto.title,
                description = dto.description
        )
    }
}