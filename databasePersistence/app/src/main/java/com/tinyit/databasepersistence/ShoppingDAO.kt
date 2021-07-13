package com.tinyit.databasepersistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDAO {
    @Insert
    fun addShoppingItem(ShoppingItem: ShoppingModel){
    }

    @Query("SELECT * FROM ShoppingModel")
    fun getAllShoppingItems():LiveData<List<ShoppingModel>>

    @Delete
    fun delete(shoppingItem: ShoppingModel)
}