package com.tinyit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.recyclerview.databinding.ActivityMainBinding
import com.tinyit.recyclerview.databinding.MusicwidgetBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var musicAdapter:MusicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var songs:List<musicModel> = listOf(
            musicModel("kpk", "mobad",false),
            musicModel("kpk", "mobad",true),
            musicModel("kpk", "mobad",true),
            musicModel("kpk", "mobad",true),
            musicModel("kpk", "mobad",true),
            musicModel("kpk", "mobad",true),
            musicModel("kpk", "mobad",true)
        )

        musicAdapter = MusicAdapter(songs)
        binding.myRecycler.adapter = musicAdapter
    }
}