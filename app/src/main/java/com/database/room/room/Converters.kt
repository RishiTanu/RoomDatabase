package com.database.room.room

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class Converters {

    @TypeConverter
    fun fromDateToLong(date: Date) : Long{
        return date.time
    }

    @TypeConverter
    fun longToDate(long: Long) : Date{
        return Date(long)
    }
}