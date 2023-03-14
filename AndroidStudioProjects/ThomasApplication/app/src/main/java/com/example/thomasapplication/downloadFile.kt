package com.example.thomasapplication

import android.util.Log
import java.net.URL
import java.net.URLConnection
import java.io.File

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