package com.alexaxms.youtrello.board

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BoardConfiguration {
    fun boardFacade(): BoardFacade {
        val boardRepository: BoardRepository = InMemoryBoardRepository()
        return boardFacade(boardRepository)
    }

    @Bean
    fun boardFacade(boardRepository: BoardRepository): BoardFacade {
        val boardCreator = BoardCreator()
        return BoardFacade(boardCreator, boardRepository)
    }
}