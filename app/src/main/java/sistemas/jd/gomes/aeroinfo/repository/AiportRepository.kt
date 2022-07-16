package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.AirportApi
import javax.inject.Inject

class AiportRepository @Inject constructor(
    private val api: AirportApi
) {
    suspend fun list(icaoCode: String? = null) = api.searchAirports(icaoCode)
    suspend fun getDetail(icaoCode: String) = api.getDetailAirports(icaoCode)
}