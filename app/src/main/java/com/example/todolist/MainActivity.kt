package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

// Подключаем интерфейс слушателя нажатий на Recycler View: Класс:ListAdapter.Listener:Интерфейс
class MainActivity : AppCompatActivity(), ListAdapter.Listener {

    //val dbManager = DBManager(this)


    lateinit var  binding: ActivityMainBinding
    private val adapter = ListAdapter(this)
    // создадим переменную launcher и укзываем что будем передавать в <> Intent
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Questionnaire"
            super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        val int = Intent(this@MainActivity, Authorization::class.java)
        startActivity(int)

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
            // Задаем в каком виде RecyclerView будет выводиться на экран: LinearLayoutManager
            rcView.layoutManager = LinearLayoutManager(this@MainActivity) // вертикальный список
            rcView.adapter = adapter
        }
    }

    override fun onClickDelete(list: Case) {
        adapter.deleteToDo(list)
        Toast.makeText(this@MainActivity, "Deleted: ${list.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onClickToDo(list: Case) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("case",list)
        })
    }

    fun buttonAddToDo(view: View) {
            // Запускаем новую активность и запустим call back, который будет ожидать данные
            // Если указать this, то будет ссылаться на binding, а нужно ссылаться на контекст Main Activity
            editLauncher?.launch(Intent(this@MainActivity, ActivityEdit::class.java))
    }
/*
    override fun onResume() {
        super.onResume()
        dbManager.openDB()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }

 */
}