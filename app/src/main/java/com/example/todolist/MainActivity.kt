package com.example.todolist

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    val adapter = ListAdapter()
    var number: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun onClickChecked(v: View){
        println("PRINT ${v}")
//        if(v.isChecked)
//            v.text = "checked"
//        else
//            check.text = "unchacked"
    }

    fun init(){ // инициализация recycler view
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) // вертикальный список
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                val list = Case("word $number")
                adapter.add(list)
                number ++
            }
        }
    }
}