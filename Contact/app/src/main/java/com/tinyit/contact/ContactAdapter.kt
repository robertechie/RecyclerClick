package com.tinyit.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.contact.databinding.ActivityMainBinding
import com.tinyit.contact.databinding.ContactItemsBinding
import com.tinyit.contact.db.ContactEntity

class ContactAdapter(var contactList:List<ContactEntity>, var click:(ContactEntity)->Unit): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
   inner class ViewHolder(var binding: ContactItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(contactItem:ContactEntity){
            binding.txtName.text = contactItem.name
            binding.root.setOnClickListener {
                click(contactItem)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding:ContactItemsBinding = ContactItemsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList.get(position))
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}