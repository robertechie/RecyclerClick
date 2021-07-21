package com.tinyit.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface TodpService {
    @GET("todos")
   suspend fun getAllTodos(): List<TodoModel>
}