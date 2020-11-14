package com.pesan.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.pesan.note.model.TodoData
import com.pesan.note.databinding.RowLayoutBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    val dataList = emptyList<TodoData>()

    class MyViewHolder(private val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(todoData: TodoData){
            binding.todoData = todoData
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): MyViewHolder
                val layoutInflater = LayoutInflater.from(parent.context)
        }
    }

}