package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.MeteorologyApi
import javax.inject.Inject

class MetereolgyRepository @Inject constructor(
    private val meteorologyApi: MeteorologyApi
) {

    suspend fun getMeteorology(icaoCode: String) = meteorologyApi.getMeteorology(icaoCode)
    suspend fun getChartSigwx() = meteorologyApi.getChartSigwx()
}