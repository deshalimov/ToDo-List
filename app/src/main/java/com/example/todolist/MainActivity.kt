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
    // создадим переменную launcher и укзываем что будем передавать в <> Intent
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        // call back новой активности
        // инициализируем переменную launcher где мы будеи ожидать ответ activity
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            // если пришел ответ по коду RESULT_OK
            if(it.resultCode == RESULT_OK){
                // полученные данные передаем в адаптер
                // данные через it получаем
                // Передаем целый класс и по этому класс должен быть serializable.
                // указываем ключевое слово
                // Нужно указывать в get extra какие данные получаем.
                adapter.add(it.data?.getSerializableExtra("case") as Case)
            }
        }

    }

    private fun init(){ // инициализация recycler view
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) // вертикальный список
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                // Запускаем новую активность и запустим call back, который будет ожидать данные
                // Если указать this, то будет ссылаться на binding, а нужно ссылаться на контекст Main Activity
                editLauncher?.launch(Intent(this@MainActivity, ActivityEdit::class.java))
                adapter.printArr()
            }
        }
    }
}