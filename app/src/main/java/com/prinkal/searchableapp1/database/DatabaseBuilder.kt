package com.prinkal.searchableapp1.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "prinkal-searchable"
        ).allowMainThreadQueries().build()

    // prinkal : not a good way to query db on main thread ,
    // I am doing this because I am fetching data via Messenger handler : IPCServerService:56

}