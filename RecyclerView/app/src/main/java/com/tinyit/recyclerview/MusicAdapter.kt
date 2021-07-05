package com.tinyit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.recyclerview.databinding.MusicwidgetBinding

class MusicAdapter(var song:List<musicModel>):RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    class MusicViewHolder(var binding:MusicwidgetBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(song:musicModel){
            binding.txtTitle.text = song.title
            binding.txtArtist.text = song.artist

            when {
                song.isPlaying -> binding.imageView.setImageResource(R.drawable.ic_pause)
                else -> binding.imageView.setImageResource(R.drawable.ic_play)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        var binding:MusicwidgetBinding = MusicwidgetBinding.inflate(LayoutInflater.from(parent.context))
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var songs = song.get(position)
        return holder.bind(songs)
    }

    override fun getItemCount(): Int {
       return song.size
    }
}