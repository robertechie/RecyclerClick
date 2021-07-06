package com.tinyit.databasepersistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.btnAdd.setOnClickListener {
            val category:String = binding.txtTitle.text.toString()
            val     description:String = binding.txtDes.text.toString()
            val shoppingItem = ShoppingModel(
                category, description
            )
            myShoppingList.add(shoppingItem)
            adapt.notifyDataSetChanged()
        }
    }
}