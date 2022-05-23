package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ListItemBinding
import java.util.concurrent.CountDownLatch

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListHolder>() {
    val array = ArrayList<Case>()
    class ListHolder(item: View): RecyclerView.ViewHolder (item) {
        val binding = ListItemBinding.bind(item)
        fun bind(list: Case) = with(binding){
            checkBox.text = list.name
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

    fun add(case: Case){
        array.add(case)
        notifyDataSetChanged() // данные изменились и нужно перерисовать
    }
}