package com.tinyit.navigationbetween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding:ActivityMainBinding
    private lateinit var second:Button
    private lateinit var third:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        second = findViewById(R.id.btnSecond)
        second.setOnClickListener {
            var i:Intent = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }

        third.setOnClickListener {
            var i:Intent = Intent(this, ThirdActivity::class.java)
            startActivity(i)
        }
    }
}