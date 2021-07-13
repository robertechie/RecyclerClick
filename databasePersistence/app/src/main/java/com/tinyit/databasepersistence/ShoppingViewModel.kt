package com.tinyit.databasepersistence

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ShoppingViewModel:ViewModel() {
    fun addShopping(shoppingItem:ShoppingModel,db:ShoppingDatabase){
        db.shoppingDao().addShoppingItem(shoppingItem)
    }

    fun getAllShoppingItem(db:ShoppingDatabase):LiveData<List<ShoppingModel>>{
        return db.shoppingDao().getAllShoppingItems()
    }

}