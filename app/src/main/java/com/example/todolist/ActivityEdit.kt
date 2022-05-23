package com.example.todolist

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todolist.databinding.ActivityEditBinding
import com.example.todolist.databinding.ActivityMainBinding
import java.io.Serializable

class ActivityEdit : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickButton()
    }

    private fun onClickButton() = with(binding){
        buttonAddFinish.setOnClickListener {

            if(etText.text.isEmpty())
                    etText.backgroundTintList = ColorStateList.valueOf(Color.RED)
            if(etNote.text.isEmpty())
                etNote.backgroundTintList = ColorStateList.valueOf(Color.RED)
            if(etText.text.isNotEmpty() && etNote.text.isNotEmpty()) {

                val editIntent = Intent().apply {
                    putExtra("case", Case(etText.text.toString(), etNote.text.toString(),false))
                }
                setResult(RESULT_OK, editIntent)
                finish()
                //Log.d("MyLog", "${etText.text.toString()} + ${etNote.text.toString()}")
            }


        }
    }

}