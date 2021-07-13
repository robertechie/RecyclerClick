package com.tinyit.retrofit

data class TodoModel(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)