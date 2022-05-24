package com.example.todolist

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.ActivityEditBinding

class ActivityEdit : AppCompatActivity() {

    // Используем View binding для activity_edit разметки
    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "New To Do"
        // Инициализируем переменную
        binding = ActivityEditBinding.inflate(layoutInflater)
        // Передаем через binding root элемент чтобы разметка показалась в activity на экране
        setContentView(binding.root)
        onClickButton()
    }

    // Инициализация кнопки через binding, чтобы каждый раз не искать по id элемента
    private fun onClickButton() = with(binding){
        // По клику на кнопку
        buttonAddFinish.setOnClickListener {
            // Если поля ввода пустые, окрасить в красный цвет
            if(etText.text.isEmpty())
                    etText.backgroundTintList = ColorStateList.valueOf(Color.RED)
            if(etNote.text.isEmpty())
                etNote.backgroundTintList = ColorStateList.valueOf(Color.RED)

            // Если поля ввода не пустые
            if(etText.text.isNotEmpty() && etNote.text.isNotEmpty()) {
                // Заполненный класс нужно отправить через Intent с помощью apply
                val editIntent = Intent().apply {
                    // Заполним класс Case и укажем ключевое слово.
                    putExtra("case", Case(etText.text.toString(), etNote.text.toString(),false))
                }
                // Отправляем результат
                setResult(RESULT_OK, editIntent)
                finish()
            }


        }
    }

}