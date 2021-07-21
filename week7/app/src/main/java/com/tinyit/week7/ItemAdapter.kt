package com.tinyit.week7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.week7.databinding.ListitemsBinding

class ItemAdapter(var Items:List<ItemModel>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
   inner class ViewHolder(var binding:ListitemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel){
            binding.txtName.text = item.name
           binding.txtPrice.text = "₦${item.price}:00"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ListitemsBinding = ListitemsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Items.get(position))
    }

    override fun getItemCount(): Int {
        return Items.size
    }
}