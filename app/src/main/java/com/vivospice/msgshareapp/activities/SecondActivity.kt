package com.vivospice.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.vivospice.msgshareapp.R.layout.activity_second
import com.vivospice.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_second)


        val bundle: Bundle? = intent.extras

       bundle?.let {
           val msg = bundle.getString("user_message")

           showToast(msg)

           txvUserMessage.text = msg
       }
    }
}