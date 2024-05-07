package com.example.listpracice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listpracice.util.ChatRoomInfo
import java.util.Collections

class ChatAdapter()
    : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private var data = mutableListOf<ChatRoomInfo>()


/*  //리스너가 null일 수도 있다.
    private var listener:OnItemClickListener ?= null

    fun addClickListener(listener: OnItemClickListener){
        this.listener= listener
    }*/

    private var listener:OnItemClickListener? = null

    fun setListener(listener: OnItemClickListener){
        this.listener = listener
    }

    fun updateData(data:MutableList<ChatRoomInfo>){
        this.data = data
        //data가 새로 들어왔으니 싹 다 다시 그려라
        notifyDataSetChanged()
    }

    fun getItemData(index: Int) = data[index]

    fun swapItem(from:Int, to:Int){
        Collections.swap(data,from,to)
        notifyItemMoved(from, to)
    }

    fun removeItem(index:Int){
        data.removeAt(index)
        notifyItemRemoved(index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_list, parent, false)
        return ChatViewHolder(view,listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val info = data[position]

        holder.imageView.setImageResource(info.image)
        holder.textViewName.text = info.name
        holder.textViewTime.text = info.time
    }


    class ChatViewHolder(view : View, listener: OnItemClickListener?): RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.imageView)
        val textViewName :TextView = view.findViewById(R.id.textViewName)
        val textViewTime : TextView = view.findViewById(R.id.textViewTime)
        init {
            view.setOnClickListener {
                listener?.OnItemClick(this.layoutPosition)
            }
        }
    }


    fun interface OnItemClickListener{
        fun OnItemClick(index: Int)
    }

}