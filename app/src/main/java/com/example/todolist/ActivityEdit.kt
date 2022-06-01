package com.example.todolist

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.todolist.databinding.ActivityEditBinding

class ActivityEdit : AppCompatActivity() {

    // Используем View binding для activity_edit разметки
    private lateinit var binding: ActivityEditBinding
    //val dbManager = DBManager(this@ActivityEdit)//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "New questions"
        // Инициализируем переменную
        binding = ActivityEditBinding.inflate(layoutInflater)
        // Передаем через binding root элемент чтобы разметка показалась в activity на экране
        setContentView(binding.root)
    }



    // Инициализация кнопки через binding, чтобы каждый раз не искать по id элемента
    fun onClickButton(view: View) = with(binding){
        val textToDo = etText.text.toString()
        val noteToDo = etNote.text.toString()
        // Если поля ввода пустые, окрасить в красный цвет
        if(textToDo.isEmpty())
            etText.backgroundTintList = ColorStateList.valueOf(Color.RED)

        // Если поля ввода не пустые
        if(etText.text.isNotEmpty()) {
            //dbManager.openDB()
            //dbManager.insertDB(textToDo, noteToDo, "false")

            //val dtList = dbManager.readDB()
            //Log.d("MyLog", "$dtList")
            // Заполненный класс нужно отправить через Intent с помощью apply
            val editIntent = Intent().apply {
                // Заполним класс Case и укажем ключевое слово.
                putExtra("case", Case(textToDo, noteToDo,"false"))
            }
            // Отправляем результат
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

}