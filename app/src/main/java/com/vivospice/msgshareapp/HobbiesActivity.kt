package com.vivospice.msgshareapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager //recyclerView is the id from hobbies_activity.xml

        val adapter = HobbiesAdapter(this, Supplier.hobbies) // Supplier.hobbies from List of <Hobby> in Model.kt
        recyclerView.adapter = adapter

    }
}