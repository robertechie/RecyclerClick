package com.tinyit.navigationbetween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private lateinit var first: Button
    private lateinit var third:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        first = findViewById(R.id.btnFF)
        third = findViewById(R.id.btnTH)
        first.setOnClickListener {
            var i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        third.setOnClickListener {
            var i: Intent = Intent(this, ThirdActivity::class.java)
            startActivity(i)
        }

    }
}