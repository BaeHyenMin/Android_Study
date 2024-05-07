package com.example.listpracice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listpracice.databinding.ActivityMainBinding
import com.example.listpracice.util.DataGenerator

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


        private val adapter = ChatAdapter()
        private val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            adapter.swapItem(viewHolder.layoutPosition, target.layoutPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.removeItem(viewHolder.layoutPosition)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonRandomData.setOnClickListener {
            adapter.updateData(DataGenerator.get())
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.recyclerView)

        adapter.setListener {
            val item = adapter.getItemData(it)
            val intent = Intent(this, RoomActivity::class.java)
            intent.putExtra("name", "${item.name}")
            startActivity(intent)
            Log.i("MainActivity","${item.name}")
        }
    }
}