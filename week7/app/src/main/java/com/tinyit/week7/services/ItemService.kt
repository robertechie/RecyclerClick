package com.tinyit.week7.services

import com.tinyit.week7.ItemModel
import com.tinyit.week7.StudentModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ItemService {
    @GET("items")
    suspend fun getAllItems():List<ItemModel>

    @GET("students")
    suspend fun getStudents():List<StudentModel>

    @POST("/students")
    suspend fun insertStudent(@Body student: StudentModel)
}