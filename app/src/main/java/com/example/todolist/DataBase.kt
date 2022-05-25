package com.example.todolist

import android.provider.BaseColumns

// Будем использовать интерфейс BaseColumns,
// потому что он работает с базой данных.
object DataBase : BaseColumns {
    // id не нужен, т.к. в BaseColumns содержит идентификатор
    // Имя базы данных.
    const val DATABASE_NAME = "MyDatabase.db"
    // Версия БД.
    const val DATABASE_VERSION = 1
    // Имя таблицы.
    const val TABLE_NAME = "my_table"
    // Имя столбца дел.
    const val COLUMN_NAME_TEXT = "text"
    // Имя столбца заметок.
    const val COLUMN_NAME_NOTE = "note"
    // Имя столбца выполнено или нет
    const val COLUMN_NAME_CHECK = "check"

    // Специальная команда, которая будет создавать таблицу в БД.
    private const val SQL_CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS ${DataBase.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                "${DataBase.COLUMN_NAME_TEXT} TEXT," +
                "${DataBase.COLUMN_NAME_NOTE} TEXT," +
                "${DataBase.COLUMN_NAME_CHECK} BOOLEAN)"
    // Специальная команда для удаления БД.
    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DataBase.TABLE_NAME}"

}