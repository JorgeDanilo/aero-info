package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.AirportApi
import sistemas.jd.gomes.aeroinfo.util.StoreAiport
import javax.inject.Inject

class AiportRepository @Inject constructor(
    private val api: AirportApi,
    private val storeAiport: StoreAiport
) {
    suspend fun list(icaoCode: String? = null) = api.searchAirports(icaoCode)
    suspend fun getDetail(icaoCode: String) = api.getDetailAirports(icaoCode)

    suspend fun saveAirport(icaoCode: String) = storeAiport.saveAirport(icaoCode)
    fun getAirportSaved() = storeAiport.readSavedAirport()
}