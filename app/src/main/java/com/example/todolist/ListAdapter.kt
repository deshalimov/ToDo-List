package com.example.todolist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ListItemBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListHolder>() {
    private val array = ArrayList<Case>()
    class ListHolder(item: View): RecyclerView.ViewHolder (item) {
        val binding = ListItemBinding.bind(item)
        fun bind(list: Case) = with(binding){
            textCheckBox.text = list.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  ListHolder(view)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount(): Int {
        return array.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun add(case: Case){
        array.add(case)
        notifyDataSetChanged() // данные изменились и нужно перерисовать
    }
}