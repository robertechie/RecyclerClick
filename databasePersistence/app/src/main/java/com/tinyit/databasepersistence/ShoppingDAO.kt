package com.tinyit.databasepersistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingDAO {
    @Insert
    fun addShoppingItem(shoppingItem: ShoppingModel){

    }

    @Query("SELECT * FROM ShoppingModel")
    fun getAllShoppingItems():List<ShoppingModel>

    @Delete
    fun delete(shoppingItem: ShoppingModel)
}