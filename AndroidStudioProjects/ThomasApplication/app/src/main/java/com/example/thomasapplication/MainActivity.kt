package com.example.thomasapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleDownload = findViewById<Button>(R.id.download_button)
        scheduleDownload.setOnClickListener{
            downloadScheduler()
        }

    }


    fun downloadScheduler(){
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val scheduledTime = setTime(timePicker)
        val currentTime = Calendar.getInstance().time
        if (currentTime >= scheduledTime.time) {
            val urlEditText = findViewById<EditText>(R.id.url_input)
            val url = urlEditText.text.toString()
            val path = "/storage/emulated/0/Download/"
            downloadFile(url, path )
        }
    }

}