package com.modanisa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoServiceApplication

fun main(args: Array<String>) {
	runApplication<ToDoServiceApplication>(*args)
}
