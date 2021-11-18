package com.prinkal.searchableapp1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prinkal.searchableapp1.data.model.SampleData

@Database(entities = [SampleData::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

}