package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.ChartsApi
import javax.inject.Inject

class ChartsRepository @Inject constructor(
    private val chartsApi: ChartsApi
) {

    suspend fun getCharts(icaoCode: String) = chartsApi.getCharts(icaoCode)
}