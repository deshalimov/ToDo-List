package com.example.todolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Нужно указать в конструкторе контекст для открытия базы данных.
// Добавляем интерфейс, который доступ к базе данных.
/*class DBHelper(context: Context): SQLiteOpenHelper(context, DataBase.DATABASE_NAME, null, DataBase.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Даем команду на создание БД.
        db?.execSQL(DataBase.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DataBase.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}*/