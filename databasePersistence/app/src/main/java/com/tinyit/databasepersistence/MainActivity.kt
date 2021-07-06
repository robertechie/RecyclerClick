package com.tinyit.databasepersistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.tinyit.databasepersistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapt:TodoAdapter
    private lateinit var myShoppingList:MutableList<ShoppingModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myShoppingList = mutableListOf()
        adapt = TodoAdapter(myShoppingList)
        binding.recyclerView.adapter = adapt

        val  db= Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).build()

        val shoppingD = db.shoppoingDAO()
        myShoppingList = shoppingD.getAllShoppingItems().toMutableList()
        adapt.notifyDataSetChanged()




        binding.btnAdd.setOnClickListener {
            val category:String = binding.txtTitle.text.toString()
            val     description:String = binding.txtDes.text.toString()
            val shoppingItem = ShoppingModel(
                category, description
            )

            shoppingD.addShoppingItem(shoppingItem)

            myShoppingList.add(shoppingItem)
            adapt.notifyDataSetChanged()
        }




    }

}