package com.vivospice.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.vivospice.msgshareapp.Constants
import com.vivospice.msgshareapp.R.layout.activity_second
import com.vivospice.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG: String = SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_second)


        val bundle: Bundle? = intent.extras

       bundle?.let {
           val msg = bundle.getString(Constants.USER_MSG_KEY)

           showToast(msg)

           txvUserMessage.text = msg
       }
    }
}