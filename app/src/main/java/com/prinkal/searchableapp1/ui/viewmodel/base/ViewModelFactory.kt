package com.prinkal.searchableapp1.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prinkal.searchableapp1.database.DatabaseHelper
import com.prinkal.searchableapp1.ui.viewmodel.MainViewModel

open class ViewModelFactory(private val mParams : Any) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mParams as DatabaseHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}