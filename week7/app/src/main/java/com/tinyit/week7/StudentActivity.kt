package com.tinyit.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.week7.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    lateinit var binding:ActivityStudentBinding
    lateinit var studentAdapter:StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnItemListing.setOnClickListener {
            var i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val viewmodel:MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //create the instance of the viewmodel
        getAllStudent(viewmodel)
        //call the insert function
        binding.btnInsert.setOnClickListener {
            when{
                (binding.txtClass.text.toString() !="" &&binding.txtName.text.toString()!="" && binding.txtSeatNo.text.toString()!="") ->
                    insertStudent(viewmodel,binding.txtClass.text.toString(), binding.txtName.text.toString(),binding.txtSeatNo.text.toString())
                else -> Toast.makeText(this, "All Fields Must Be Filled", Toast.LENGTH_SHORT)
            }

        }


    }

    private fun getAllStudent(viewmodel:MainViewModel){

        viewmodel.StudentObservable().observe(this@StudentActivity){
                Items ->
            studentAdapter = StudentAdapter(Items)
            binding.studentRecycler.adapter = studentAdapter
            studentAdapter.notifyDataSetChanged()
        }
    }


    private fun insertStudent(viewmodel:MainViewModel,txtClass:String,txtName:String, txtSeatNo:String) {

        val student = StudentModel(txtClass, txtName, txtSeatNo)
        viewmodel.insertStudent(student)
        studentAdapter.notifyDataSetChanged()
        getAllStudent(viewmodel)
        //Toast.makeText(this, "Succesfully insertd", Toast.LENGTH_SHORT)

    }
}