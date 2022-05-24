package com.example.todolist

import android.annotation.SuppressLint
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ListItemBinding
import java.nio.file.Files.delete

// Список из data классов Case.
var array = ArrayList<Case>()

// Созадим класс адаптер. Нужно унаследовать его от Recycler View Adapter.
// Нужно указать View Holder, специальный класс, который будет содержать все
// ссылки на элементы (в нашем случае одно текстовое поле).
// Создадим класс внутри класса который будет в себе хранить ссылки View Holder
// и назовем его ListHolder и это будет View Holder.
class ListAdapter: RecyclerView.Adapter<ListAdapter.ListHolder>() {

    // Так как ListView является View Holder, нужно унаследоваться от
    // RecyclerView ViewHolder. ViewHolder должен в себе нести View элемент, который будем "надувать".
    // Это одна разметка-шаблон, с помощью которого и будем заполнять RecyclerView.
    class ListHolder(item: View): RecyclerView.ViewHolder (item) {
        private val binding = ListItemBinding.bind(item)
        // Из этой функции будем брать данные
        fun bind(list: Case) = with(binding){

            textCheckBox.text = list.name

            checkBox.setOnClickListener{
                if(checkBox.isChecked){
                    textCheckBox.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                    list.check = true
                }
                else {
                    textCheckBox.paintFlags = Paint.ANTI_ALIAS_FLAG
                    list.check = false
                }
            }

            deleteButton.setOnClickListener {
//                val arr = ArrayList<Case>()
//                array.forEach{
//                    if(it != list)
//                        arr.add(it)
//                }
//                array = arr

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        // Создаем View.
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

    fun printArr(){
        Log.d("MyLog", "$array")
    }
}