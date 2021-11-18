package com.prinkal.searchableapp1.database

import android.database.Cursor
import com.prinkal.searchableapp1.data.model.SampleData

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override fun getAll(): List<SampleData>? = appDatabase.dataDao().getAll()
    override fun getSearchedResult(title: String, description: String): List<SampleData>? =
        appDatabase.dataDao().getSearchedResult(title, description)


    override fun getAllAsCursor(): Cursor = appDatabase.dataDao().getAllAsCursor()
    override fun getSearchedResultAsCursor(title: String, description: String): Cursor =
        appDatabase.dataDao().getSearchedResultAsCursor(title, description)

    override fun insertAll(data: List<SampleData>) = appDatabase.dataDao().insertAll(data)
    override fun insert(data: SampleData): Long = appDatabase.dataDao().insert(data)

}