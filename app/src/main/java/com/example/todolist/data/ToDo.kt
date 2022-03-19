package com.example.todolist.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDo (val title: String, val description: String, val priority: Int, val date: String): Parcelable