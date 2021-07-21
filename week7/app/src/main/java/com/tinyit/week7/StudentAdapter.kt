package com.tinyit.week7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.week7.databinding.StudentitemBinding

class StudentAdapter(var Items:List<StudentModel>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
   inner class ViewHolder(var binding:StudentitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StudentModel){
            binding.txtName.text = item.name
            binding.txtClass.text = "Class: ${item.`class`.toString()}"
            binding.txtSeat.text = "Seat No: ${item.seat}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:StudentitemBinding = StudentitemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Items.get(position))
    }

    override fun getItemCount(): Int {
        return Items.size
    }
}