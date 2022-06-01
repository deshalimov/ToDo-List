package com.example.todolist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
/*
class DBManager(val context: Context) {
    // Инициализируем DBHelper.
    val dbhelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    // Открываем БД.
    fun openDB(){
        // Чтобы БД открылась для записи.
        // DBHelper не может записывать.
        db = dbhelper.writableDatabase
    }

    // Записываем в БД.
    fun insertDB(name: String, note: String, check: String){
        val values = ContentValues().apply {
            put(DataBase.COLUMN_NAME_TEXT, name)
            put(DataBase.COLUMN_NAME_NOTE, note)
            put(DataBase.COLUMN_NAME_CHECK, check)
        }
        db?.insert(DataBase.TABLE_NAME, null, values)
    }

    // Считываем БД.
    fun readDB(): ArrayList<String>{
        val cursor = db?.query(DataBase.TABLE_NAME, null, null, null, null, null, null)

        val arr = ArrayList<String>()
            while(cursor?.moveToNext() == true){
                val cursorText = cursor.getString(cursor.getColumnIndexOrThrow(DataBase.COLUMN_NAME_TEXT))
                //val cursorNote = cursor.getString(cursor.getColumnIndexOrThrow(DataBase.COLUMN_NAME_NOTE))
                //val cursorCheck = cursor.getString(cursor.getColumnIndexOrThrow(DataBase.COLUMN_NAME_CHECK))
                //if (cursorCheck != null) {
                    //arr.add(Case(cursorText.toString(), cursorNote.toString(), cursorCheck.toString()))
                //}
                arr.add(cursorText)

        }
        cursor?.close()
        return arr
    }

    fun closeDB(){
        dbhelper.close()
    }
}

 */