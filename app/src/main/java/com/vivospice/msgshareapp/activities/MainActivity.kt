package com.vivospice.msgshareapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.vivospice.msgshareapp.Constants
import com.vivospice.msgshareapp.R
import com.vivospice.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i(TAG, resources.getString(R.string.btn_was_clicked))
            showToast(resources.getString(R.string.btn_was_clicked), Toast.LENGTH_SHORT)

        }

        btnSendMsgToNextActivity.setOnClickListener {

            val message: String = etUserMessage.text.toString()
            // Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, resources.getString(R.string.txtShareTo)))

        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
