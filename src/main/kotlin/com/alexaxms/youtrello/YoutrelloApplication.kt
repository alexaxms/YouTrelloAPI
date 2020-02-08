package com.alexaxms.youtrello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YoutrelloApplication

fun main(args: Array<String>) {
	runApplication<YoutrelloApplication>(*args)
}
