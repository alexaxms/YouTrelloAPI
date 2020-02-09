package com.alexaxms.youtrello.board

import com.alexaxms.youtrello.board.dto.BoardDto
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.data.domain.PageRequest

class BoardTest : Spek({
    describe("should create a board") {
        val facade = BoardConfiguration().boardFacade()
        val board1 = BoardDto("Sprint 1", "Created board to test")
        describe("we create a board") {
            facade.add(board1)
            it("system has this board") {
                assertEquals(facade.showBoardDetails(board1.title),  board1)
            }
        }
    }

    describe("should get boards") {
        val facade = BoardConfiguration().boardFacade()
        val board1 = BoardDto("Sprint 1", "Created board to test")
        val board2 = BoardDto("Sprint 2", "Created board to test")
        describe("we create 2 boards") {
            facade.add(board1)
            facade.add(board2)
            it("system should list boards") {
                val boards = facade.findBoards(PageRequest.of(0, 10))
                assertEquals(boards?.size,  2)
            }
        }
    }
})