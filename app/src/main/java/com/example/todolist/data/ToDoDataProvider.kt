package com.example.todolist.data

import java.text.SimpleDateFormat
import java.util.*

object ToDoDataProvider {
    private val list = mutableListOf<ToDo>()

    init {
        for (i in 1..10) {
            list.add(
                ToDo(
                    "Title $i",
                    "Description $i",
                    (0..10).random(),
                    SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                )
            )
        }
    }

    fun getData(): List<ToDo> {
        return list
    }

    fun addData(todo: ToDo) {
        list.add(todo)
    }
}