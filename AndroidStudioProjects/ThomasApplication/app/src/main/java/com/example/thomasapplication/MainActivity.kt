package com.example.thomasapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import java.io.File
import java.net.URL
import java.net.URLConnection
import java.util.*

class MainActivity : AppCompatActivity() {
    var toggle = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleDownload = findViewById<Button>(R.id.download_button)
        scheduleDownload.setOnClickListener{
            Log.e("sinal","es funktioniert")
            toggle = true
            downloadScheduler()
        }

    }


    private fun downloadScheduler(){
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        Log.e("sinal","timePicker: $timePicker")

        val scheduledTime = setTime(timePicker)

        while (toggle) {
            val currentTime = Calendar.getInstance().time
            //Log.e("sinal", "currentTime: $currentTime")
            //Log.e("sinal", "scheduledTime: ${scheduledTime.time}")



            if (currentTime >= scheduledTime.time) {
                toggle =false
                val urlEditText = findViewById<EditText>(R.id.url_input)
                //val url = urlEditText.text.toString()
                val url = "https://www.orimi.com/pdf-test.pdf"
                val path = this.getExternalFilesDir(null)?.absolutePath + "/Downsloads/pdf-test.pdf"
                Log.e("sinal", "url: $url")
                Log.e("path", "path: $path")

                Thread(Runnable {
                downloadFile(url, path)
            }).start()

            }
        }
    }
    private fun setTime(timePicker: TimePicker): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.hour)
        // hier hattest du .hour statt .minute
        calendar.set(Calendar.MINUTE, timePicker.minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar
    }

    fun downloadFile(urlString: String, savePath: String) {
        val url = URL(urlString)
        val connection: URLConnection = url.openConnection()
        connection.connect()
        val inputStream = connection.getInputStream()
        val file = File(savePath)
        if (!file.isFile) {
            Log.e("path","The specified path is not a valid file path.")
        }else{

            file.outputStream().use { outputStream ->
                inputStream.copyTo(outputStream)
            }
            inputStream.close()
        }
    }
}


