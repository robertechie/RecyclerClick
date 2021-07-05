package com.tinyit.recyclerclick

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.recyclerclick.databinding.ProfileBinding
import dtos.UserProfile


class UserAdapter(public var context: Context, var User:List<UserProfile>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var binding:ProfileBinding = ProfileBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = User.get(position)
        holder.bind(user)




    }
    override fun getItemCount(): Int {
        return User.size
    }

    inner class UserViewHolder(var userBinding:ProfileBinding):RecyclerView.ViewHolder(userBinding.root){

        fun bind(userProfile:UserProfile ){
            userBinding.txtSurName.text = userProfile.surName
            userBinding.txtFullName.text = userProfile.otherName
            userBinding.imgProfile.setImageResource(userProfile.img)


            userBinding.userCard.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    val i: Intent
                    i = Intent(context,UserDetailsActivity::class.java)
                    i.putExtra("surName",userProfile.surName)
                    i.putExtra("lastName",userProfile.otherName)
                    i.putExtra("img", userProfile.img)

                    context.startActivity(i)




                }
            })



        }
    }




}