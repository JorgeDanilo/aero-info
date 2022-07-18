package sistemas.jd.gomes.aeroinfo.util

import java.text.SimpleDateFormat
import java.util.*

private const val PATTERN_DATE = "dd/MM/yyyy HH:mm"

fun timeNow(): String {
    val calendar: Calendar = Calendar.getInstance()
    val sdf = SimpleDateFormat(PATTERN_DATE)
    return sdf.format(calendar.time)
}