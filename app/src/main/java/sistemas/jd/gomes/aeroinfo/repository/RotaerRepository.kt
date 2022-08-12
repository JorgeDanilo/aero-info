package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.RotaerApi
import javax.inject.Inject

class RotaerRepository @Inject constructor(
    private val rotaerApi: RotaerApi
) {
    suspend fun getRotaer(icaoCode: String) = rotaerApi.getRotaer(icaoCode)
}