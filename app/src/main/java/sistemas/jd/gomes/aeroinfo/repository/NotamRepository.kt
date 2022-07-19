package sistemas.jd.gomes.aeroinfo.repository

import sistemas.jd.gomes.aeroinfo.data.remote.NotamApi
import javax.inject.Inject

class NotamRepository @Inject constructor(
    private val notamApi: NotamApi
) {
    suspend fun getNotam(icaoCode: String) = notamApi.getNotam(icaoCode)
}