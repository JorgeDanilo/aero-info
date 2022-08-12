package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.SunriseDayApi
import javax.inject.Inject

class SunsetDayRepository @Inject constructor(
    private val sunsetApi: SunriseDayApi
) {

    suspend fun getSunsetDay(icaoCode: String, startDate: String, endDate: String) =
        sunsetApi.getSunsetDay(icaoCode, startDate, endDate)
}