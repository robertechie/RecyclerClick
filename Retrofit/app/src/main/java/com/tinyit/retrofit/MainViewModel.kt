package com.tinyit.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel:ViewModel() {
    lateinit var todos:MutableLiveData<List<TodoModel>>
    init {
        todos = MutableLiveData()
        getAllTodos()
    }

    fun getAllTodosObserver():MutableLiveData<List<TodoModel>>{
        return todos;
    }

//    fun getAllTodos(){
//       viewModelScope.launch(Dispatchers.IO) {
//           var todo: List<TodoModel> = RetrofitProvider.service.getAllTodos()
//           todos.postValue(todo)
//       }
//    }

    fun getAllTodos(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val todo: List<TodoModel> = RetrofitProvider.service.getAllTodos()
                todos.postValue(todo)
            }
        }catch (e: Exception){
            Log.e("ViewModel", e.message.toString())
        }

    }



}