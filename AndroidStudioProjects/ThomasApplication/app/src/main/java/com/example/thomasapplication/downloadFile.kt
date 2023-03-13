package com.example.thomasapplication

import java.net.URL
import java.net.URLConnection
import java.io.File

fun downloadFile(urlString: String, savePath: String) {
    val url = URL(urlString)
    val connection: URLConnection = url.openConnection()
    connection.connect()
    val inputStream = connection.getInputStream()
    val file = File(savePath)
    file.outputStream().use { outputStream ->
        inputStream.copyTo(outputStream)
    }
    inputStream.close()
}