package space.nahlmb.log.core.utils

import androidx.room.TypeConverter
import java.util.Date

class RoomDateConverterUtil {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}