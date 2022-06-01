package com.example.todolist

import android.provider.BaseColumns

// Будем использовать интерфейс BaseColumns,
// потому что он работает с базой данных.
object DataBase : BaseColumns {
    object FeedEntery: BaseColumns {
        // id не нужен, т.к. в BaseColumns содержит идентификатор
        // Имя базы данных.
        const val DATABASE_NAME = "MyDatabase.db"

        // Версия БД.
        const val DATABASE_VERSION = 100

        // Имя таблицы.
        const val TABLE_NAME = "my_table"

        // Имя столбца дел.
        const val COLUMN_NAME_TEXT = "text"

        // Имя столбца заметок.
        const val COLUMN_NAME_NOTE = "note"

        // Имя столбца выполнено или нет
        const val COLUMN_NAME_CHECK = "check"

        // Специальная команда, которая будет создавать таблицу в БД.
        const val SQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TEXT TEXT,$COLUMN_NAME_NOTE TEXT,$COLUMN_NAME_CHECK TEXT)"

        // Специальная команда для удаления БД.
        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}