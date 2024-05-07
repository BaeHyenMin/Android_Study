package com.example.members.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.members.R
import com.example.members.model.User

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var listener: OnItemSelected? = null
    private var data: List<User> = listOf()

    fun updateData(data: List<User>) {
        this.data = data
        notifyItemRangeChanged(0, data.size)
    }

    fun addListener(listener: OnItemSelected) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }
    fun interface OnItemSelected {
        fun onItemSelected(user: User)
    }

    inner class UserViewHolder(v: View): RecyclerView.ViewHolder(v){
        private val textViewName: TextView = v.findViewById(R.id.textViewName)
        private val textViewEmail:TextView = v.findViewById(R.id.textViewEmail)
        private val textViewPhone:TextView = v.findViewById(R.id.textViewPhone)
        private val textViewCompanyName:TextView = v.findViewById(R.id.textViewCompanyName)
        private lateinit var user:User

        init {
            v.setOnClickListener {
                listener?.onItemSelected(user)
            }
        }

        fun bind(user:User){
            this.user = user
            textViewName.text = user.name
            textViewEmail.text = user.email
            textViewPhone.text = user.phonoe
            textViewCompanyName.text = user.company.name
        }

    }

}