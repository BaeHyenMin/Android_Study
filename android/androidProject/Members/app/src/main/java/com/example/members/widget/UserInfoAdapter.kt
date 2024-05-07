package com.example.members.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.members.R
import com.example.members.model.User

class UserInfoAdapter : RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHoler>(){



    inner class UserInfoViewHoler(v:View) : RecyclerView.ViewHolder(v){
        private val textViewName : TextView = v.findViewById(R.id.textViewName)
        private val textViewEmail : TextView = v.findViewById(R.id.textViewEmail)
        private val textViewAddress : TextView = v.findViewById(R.id.textViewAddress)
        private lateinit var user : User

        fun bind(user:User){
            this.user = user
            textViewName.text = user.username
            textViewEmail.text = user.email
            textViewAddress.text = user.address.city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHoler {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserInfoViewHoler, position: Int) {
        TODO("Not yet implemented")
    }


}