package com.prinkal.searchableapp1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prinkal.searchableapp1.data.model.SampleData
import com.prinkal.searchableapp1.database.DatabaseHelper
import com.prinkal.searchableapp1.utils.DummyDataGenerator
import com.prinkal.searchableapp1.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dbHelper: DatabaseHelper) : ViewModel() {

    private val users = MutableLiveData<Resource<List<SampleData>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(Resource.loading(null))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var userList = dbHelper.getAll()
                if (userList.isNullOrEmpty()) {
                    dbHelper.insertAll(DummyDataGenerator.getSampleData())
                    userList = dbHelper.getAll()
                }
                users.postValue(Resource.success(userList))
            } catch (e: Exception) {
                e.printStackTrace()
                users.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<SampleData>>> {
        return users
    }

    fun addSampleDataAndUpdate(title: String, desc: String) {
        viewModelScope.launch {
            dbHelper.insert(SampleData(0, title, desc, desc))
            val userList = dbHelper.getAll()
            users.postValue(Resource.success(userList))
        }
    }

}