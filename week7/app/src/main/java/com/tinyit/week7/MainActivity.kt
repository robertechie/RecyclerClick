package com.tinyit.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tinyit.week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var itemAdapter:ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            var i: Intent = Intent(this, StudentActivity::class.java)
            startActivity(i)
        }

        //create the instance of the viewmodel
        val viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        viewmodel.ItemObservable().observe(this@MainActivity){
            Items ->
           // binding.lblTry.text =Items.toString()
            itemAdapter = ItemAdapter(Items)
            binding.ItemsRecycler.adapter = itemAdapter
            itemAdapter.notifyDataSetChanged()

        }

    }
}