package com.prinkal.searchableapp1.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.prinkal.searchableapp1.data.model.SampleData

@Dao
interface DataDao {

    @Query("SELECT * FROM sampledata ORDER BY id desc")
    fun getAll(): List<SampleData>?

    @Query("SELECT * FROM sampledata ORDER BY id desc")
    fun getAllAsCursor(): Cursor

    @Query("SELECT * FROM sampledata where title LIKE '%' || :title || '%' or description LIKE '%' || :description || '%' ")
    fun getSearchedResultAsCursor(title: String, description: String): Cursor

    @Query("SELECT * FROM sampledata where title LIKE '%' || :title || '%' or description LIKE '%' || :description || '%' ")
    fun getSearchedResult(title: String, description: String): List<SampleData>?

    @Insert
    fun insertAll(data: List<SampleData>)

    @Insert
    fun insert(data: SampleData): Long

    @Delete
    fun delete(data: SampleData)

}