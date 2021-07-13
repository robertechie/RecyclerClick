package com.tinyit.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tinyit.contact.databinding.ActivityMainBinding
import com.tinyit.contact.databinding.BottomSheetBinding
import com.tinyit.contact.databinding.ContactItemsBinding
import com.tinyit.contact.db.ContactEntity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var contactAdapter:ContactAdapter
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllContactObservers().observe(this, Observer {
            contactAdapter = ContactAdapter(it, {
                var bottomSheet:BottomSheetDialog= BottomSheetDialog(this, R.style.bottomSheetDialogTheme)
                var sheet: BottomSheetBinding = BottomSheetBinding.inflate(layoutInflater)
                sheet.txtSheetName.text = it.name
                sheet.txtSheetPhone.text = it.phone.toString()
                sheet.txtSheetEmail.text = it.email
                sheet.txtSheetAddress.text = it.address
                bottomSheet.setContentView(sheet.maincointener)
                bottomSheet.show()
            })
            binding.contacts.adapter = contactAdapter
            contactAdapter.notifyDataSetChanged()
        })


        binding.save.setOnClickListener {
            try {
                val phone  = binding.phoneNumber.text.toString().toLong()
                val email  = binding.email.text.toString()
                val name = binding.txtName.text.toString()
                val address = binding.txtAddress.text.toString()
                if(phone.toLong() == null ||email.toString() =="" ||name.toString()==""|| address.toString()==""){
                    Toast.makeText(this, "No field should be empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else{
                    val contact = ContactEntity(0, phone, email, name, address)
                    viewModel.insertUserInfo(contact)
                    //clear the the fields after insertion
                    binding.phoneNumber.setText("")
                    binding.email.setText("")
                    binding.txtName.setText("")
                    binding.txtAddress.setText("")
                }
            }catch (ex:Exception){
                Toast.makeText(this, "Input only number on the phone field", Toast.LENGTH_SHORT).show()
            }




        }
    }

    }
