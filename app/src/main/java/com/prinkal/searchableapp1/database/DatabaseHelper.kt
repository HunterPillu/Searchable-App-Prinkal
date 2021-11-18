package com.prinkal.searchableapp1.database

import android.database.Cursor
import com.prinkal.searchableapp1.data.model.SampleData

interface DatabaseHelper {

    fun getAll(): List<SampleData>?
    fun getSearchedResult(title: String, description: String): List<SampleData>?

    fun getAllAsCursor(): Cursor
    fun getSearchedResultAsCursor(title: String, description: String): Cursor

    fun insertAll(data: List<SampleData>)

    fun insert(data: SampleData): Long

}