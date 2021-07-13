package com.tinyit.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface TodpService {
    @GET("todos")
    fun getAllTodos(): Call<List<TodoModel?>?>?
}