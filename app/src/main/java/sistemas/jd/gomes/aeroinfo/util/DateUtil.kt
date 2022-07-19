package sistemas.jd.gomes.aeroinfo.util

import java.text.SimpleDateFormat
import java.util.*

private const val PATTERN_DATE = "dd/MM/yyyy HH:mm"
const val DATE_FORMAT_VIEW = "MM/yyyy"
const val DATE_FORMAT_JSON = "yyyy-MM-dd"
private const val DATE_FORMAT_VIEW_FULL = "dd/MM/yyyy"
private const val MONTH_NAME_YEAR_PATTERN = "MMM yyyy"
private const val YEAR_MONTH_PATTERN = "yyyy-MM"
private const val MINUTES_SECONDS_MORE_THAN_10_MINUTES_FORMAT = "mm:ss"
private const val MINUTES_SECONDS_LESS_THAN_10_MINUTES_FORMAT = "m:ss"
private const val YEAR_IN_MONTH = 12

object DateUtil {

    @JvmStatic
    fun now(): Date {
        return TimeMachine().now()
    }

    fun timeNow(): String {
        val calendar: Calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat(PATTERN_DATE)
        return sdf.format(calendar.time)
    }

    fun timeNowToJson(): String {
        val calendar: Calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat(DATE_FORMAT_JSON)
        return sdf.format(calendar.time)
    }

    @JvmStatic
    fun sumDays(baseDate: Date, days: Int): Date {
        val calendar = calendarFrom(baseDate)
        calendar.add(Calendar.DAY_OF_MONTH, days)
        return calendar.time
    }

    @JvmStatic
    fun formatDateToJson(date: Date): String {
        val sdf = SimpleDateFormat(DATE_FORMAT_JSON)
        return sdf.format(date.time)
    }

    @JvmStatic
    fun subtractDays(baseDate: Date, days: Int): Date {
        return sumDays(baseDate, -days)
    }

    @JvmStatic
    fun calendarFrom(date: Date): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar
    }

    @JvmStatic
    fun formatDate(strData: String): String {
        return try {
            val year = strData.substring(0, 2)
            val month = strData.substring(2, 4)
            val day = strData.substring(4, 6)
            val hour = strData.substring(4, 6)
            val minutes = strData.substring(8, 10)
            "$day/$month/$year $hour:$minutes"
        } catch (e: Exception) {
            ""
        }
    }
}
