package com.vivospice.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.vivospice.msgshareapp.adapters.HobbiesAdapter
import com.vivospice.msgshareapp.R
import com.vivospice.msgshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager //recyclerView is the id from hobbies_activity.xml

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        // Supplier.hobbies from List of <Hobby> in Model.kt
        recyclerView.adapter = adapter
    }
}
