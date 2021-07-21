package com.tinyit.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tinyit.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var todoAdapter:TodoAdapter
    private lateinit var viewModel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter(listOf())
        binding.recyView.adapter = todoAdapter

        val viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.apply {
            //getAllTodos()
            todos.observe(this@MainActivity){ todos ->
                todoAdapter.listitem = todos
                todoAdapter.notifyDataSetChanged()
            }
        }

//        viewModel.getAllTodosObserver().observe(this, Observer {
//            if(it !=null){
//                it.body().let { items->
//                    todoAdapter.listitem =items as List<TodoModel>
//                        todoAdapter.notifyDataSetChanged()
//
//                }
//            }
//        })



    }
}