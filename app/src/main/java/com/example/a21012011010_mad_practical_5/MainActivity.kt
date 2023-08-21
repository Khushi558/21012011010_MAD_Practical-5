package com.example.a21012011010_mad_practical_5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.security.Key

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implicitintent()
    }
    private fun implicitintent()
    {
        findViewById<Button>(R.id.button_browse).setOnClickListener {
            Log.i("Click_url", "MainActivity ")
            Intent(Intent.ACTION_VIEW, Uri.parse(findViewById<EditText>(R.id.text_input_url).text.toString())).also { startActivity(it) }
        }
        findViewById<Button>(R.id.phone_button).setOnClickListener {
            Log.i("Click_Phone","MainActivity")
            val number=findViewById<EditText>(R.id.phone_url).text.toString().trim()
            Intent(Intent.ACTION_DIAL).setData((Uri.parse("Tel:$number"))).apply {
                startActivity(this)
            }
        findViewById<Button>(R.id.call_log).setOnClickListener {
            Log.i("Click_call-log","MainActivity")
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
        }
        findViewById<Button>(R.id.gallery).setOnClickListener {
            Log.i("Click_Gallery","MainActivity")
            Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
        }
         findViewById<Button>(R.id.camera).setOnClickListener {
             Log.i("Click_Camera","MainActivity")
             Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
         }
          findViewById<Button>(R.id.alarm).setOnClickListener {
              Log.i("Click_Alarm","MainActivity")
              Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
          }
        }

    }
}
