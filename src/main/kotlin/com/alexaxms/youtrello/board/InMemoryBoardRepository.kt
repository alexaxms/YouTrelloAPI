package com.alexaxms.youtrello.board

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Optional;


class InMemoryBoardRepository : BoardRepository{
    var store: HashMap<String, Board> = HashMap<String, Board>()

    override fun save(board: Board) {
        this.store[board.title] = board;
    }

    override fun findByTitle(title: String): Board? {
        return store[title]
    }

    override fun findAll(pageable: Pageable): Page<Board> {
        return PageImpl(ArrayList(store.values))
    }
}