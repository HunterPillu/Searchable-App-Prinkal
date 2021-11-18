package com.prinkal.searchableapp1.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.prinkal.searchableapp1.R
import com.prinkal.searchableapp1.data.model.SampleData
import com.prinkal.searchableapp1.database.DatabaseBuilder
import com.prinkal.searchableapp1.database.DatabaseHelperImpl
import com.prinkal.searchableapp1.ui.adapter.MainAdapter
import com.prinkal.searchableapp1.ui.viewmodel.MainViewModel
import com.prinkal.searchableapp1.ui.viewmodel.base.ViewModelFactory
import com.prinkal.searchableapp1.utils.Status
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupUI()
        setupViewModel()
        setupObserver()

        bAdd.setOnClickListener(this)
    }


    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.IDLE -> {
                    //this is not required prinkal
                }
            }
        })
    }

    private fun renderList(users: List<SampleData>) {
        adapter.apply {
            clearData()
            addData(users)
            notifyDataSetChanged()
        }
    }

    private fun setupViewModel() {
        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(dbHelper)
        )[MainViewModel::class.java]
    }

    override fun onClick(v: View?) {
        val title = etTitle.text.toString()
        val desc = etDesc.text.toString()

        if (title.isEmpty() || desc.isEmpty()) {
            Toast.makeText(this, R.string.invalid_msg, Toast.LENGTH_SHORT).show()
        } else {
            mainViewModel.addSampleDataAndUpdate(title, desc)
        }

        etTitle.setText("")
        etDesc.setText("")
    }
}