package com.example.members.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.members.R
import com.example.members.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var data:List<Post> = listOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_post, parent, false)
            return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(data:List<Post>){
        this.data = data
        notifyItemRangeChanged(0, data.size)
    }

    inner class PostViewHolder(v:View): RecyclerView.ViewHolder(v){
        private val textViewTitle : TextView = v.findViewById(R.id.textViewTitle)
        private val textViewUser : TextView = v.findViewById(R.id.textViewUser)
        private val textViewBody : TextView = v.findViewById(R.id.textViewBody)
        private lateinit var post : Post
        fun bind(post:Post){
            this.post = post
            textViewTitle.text = post.title
            textViewUser.text = post.userId.toString()
            textViewBody.text = post.body
        }
    }
}