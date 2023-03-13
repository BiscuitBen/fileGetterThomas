package com.example.thomasapplication

import android.widget.TimePicker
import java.util.Calendar

fun setTime(timePicker: TimePicker): Calendar {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, timePicker.hour)
    calendar.set(Calendar.MINUTE, timePicker.hour)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    return calendar
}


