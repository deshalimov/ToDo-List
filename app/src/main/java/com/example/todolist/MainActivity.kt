package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    private val adapter = ListAdapter()
    var number: Int = 0
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        // call back новой активности
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.add(it.data?.getSerializableExtra("case") as Case)
            }
        }

    }

    private fun init(){ // инициализация recycler view
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) // вертикальный список
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{

                editLauncher?.launch(Intent(this@MainActivity, ActivityEdit::class.java))
//                val list = Case("word $number", "", true)
//                adapter.add(list)
//                number ++
            }
        }
    }
}