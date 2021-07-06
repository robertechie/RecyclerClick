package com.tinyit.navigationbetween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class ThirdActivity : AppCompatActivity() {
    private lateinit var first: Button
    private lateinit var second:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        first = findViewById(R.id.btnFirst)
        second = findViewById(R.id.btnSec)
        first.setOnClickListener {
            var i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        second.setOnClickListener {
            var i: Intent = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }
    }
}