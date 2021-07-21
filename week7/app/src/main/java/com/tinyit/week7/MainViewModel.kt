package com.tinyit.week7

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel(){
    lateinit var ItemRepo:MutableLiveData<List<ItemModel>>
    lateinit var StudentRepo:MutableLiveData<List<StudentModel>>

    init {
        ItemRepo = MutableLiveData()
        StudentRepo = MutableLiveData()
        getAllItems()
        getAllStudent()
    }

    fun ItemObservable():MutableLiveData<List<ItemModel>> {
        return ItemRepo
    }

    fun StudentObservable():MutableLiveData<List<StudentModel>> {
        return StudentRepo
    }

    fun getAllItems(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val items: List<ItemModel> = RetrofitProvider.service.getAllItems()
                ItemRepo.postValue(items)
            }
        }catch (e: Exception){
            Log.e("ViewModel", e.message.toString())
        }

    }



    //get all student
    fun getAllStudent(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val items: List<StudentModel> = RetrofitProvider.service.getStudents()
                StudentRepo.postValue(items)
            }
        }catch (e: Exception){
            Log.e("ViewModel", e.message.toString())
        }

    }

    //post student
    fun insertStudent(student: StudentModel){
        try {
            CoroutineScope(Dispatchers.IO).launch {
               val cv = RetrofitProvider.service.insertStudent(student)

            }
        }catch (e: Exception){
// Log.e("ViewModel", e.message.toString())
print(e.message.toString())
        }

    }


}