package com.tinyit.databasepersistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        val viewMode=ViewModelProvider(this)[ShoppingViewModel::class.java]

        val  db= Room.databaseBuilder<ShoppingDatabase>(
            applicationContext,
            ShoppingDatabase::class.java, "ShoppingDatabase"
        ).allowMainThreadQueries().build()

        val shoppingD = db.shoppingDao()
        viewMode.getAllShoppingItem(db).observe(this, Observer {
            adapt = TodoAdapter(it)
            binding.recyclerView.adapter = adapt
            adapt.notifyDataSetChanged()
        })


        binding.btnAdd.setOnClickListener {
            var  category:String = binding.txtTitle.text.toString()
            var description:String = binding.txtDes.text.toString()
            val shoppingItem = ShoppingModel(category, description,0)
            viewMode.addShopping(shoppingItem, db)
            adapt.notifyDataSetChanged()
        }




    }

}