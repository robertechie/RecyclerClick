package com.tinyit.recyclerclick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tinyit.recyclerclick.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val surName: String = intent.getStringExtra("surName").toString()
        val lastName: String = intent.getStringExtra("lastName").toString()
        val img: Int = intent.getIntExtra("img",9)
        binding.txtDetailsSurName.text = surName
        binding.txtDetailsLastName.text = lastName
        binding.imgDetailsPhoto.setImageResource(img)

    }
}