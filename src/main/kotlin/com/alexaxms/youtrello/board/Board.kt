package com.alexaxms.youtrello.board

import com.alexaxms.youtrello.board.dto.BoardDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Board(
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Column
        val title: String = "",

        @Column
        val description: String = ""
) {
    fun dto(): BoardDto {
        return BoardDto(this.title, this.description)
    }
}
