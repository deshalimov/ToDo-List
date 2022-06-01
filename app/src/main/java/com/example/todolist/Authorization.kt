package com.example.todolist

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.todolist.databinding.ActivityAutorizationBinding

val listAutorization = ArrayList<AutorizationData>()


class Authorization : AppCompatActivity() {
    lateinit var binding: ActivityAutorizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAutorizationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // инициализируем данные пользователей
        authorizeDT()

        title = "Autorization"
    }

    private fun authorizeDT() {
        listAutorization.add(AutorizationData("Denis", "123"))
        listAutorization.add(AutorizationData("Vladislav", "123"))
        listAutorization.add(AutorizationData("Maksim", "123"))
    }

    fun btnEnterAutorize(view: View) = with(binding) {
        if (listAutorization.isNotEmpty()) {

            if(etUserName.text.toString() == "" )
                etUserName.backgroundTintList = ColorStateList.valueOf(Color.RED)
            else etUserName.backgroundTintList = ColorStateList.valueOf(Color.BLACK)

            if(etPassword.text.toString() == "" )
                etPassword.backgroundTintList = ColorStateList.valueOf(Color.RED)
            else etPassword.backgroundTintList = ColorStateList.valueOf(Color.BLACK)

            listAutorization.forEach {
                // если найден логин
                if (it.name == etUserName.text.toString()) {
                    ErrorUsernameText.visibility = View.GONE
                    errorPasswordText.visibility = View.GONE
                    // если найден пароль
                    if(it.password == etPassword.text.toString())
                    {
                        // закрыть активность
                        finish()
                    }
                    // если найден логин, но не найден пароль
                    else {
                        ErrorUsernameText.visibility = View.GONE
                        errorPasswordText.visibility = View.VISIBLE
                    }
                }
                // если логин не найден - ошибка
                else {
                    ErrorUsernameText.visibility = View.VISIBLE

                }

            }

        }

    }
}