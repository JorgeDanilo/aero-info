package sistemas.jd.gomes.aeroinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sistemas.jd.gomes.aeroinfo.data.model.SunriseDayResponse
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.Xml

interface SunriseDayApi {

    @GET("${Constants.BASE_URL_AISWEB}/?apiKey=${Constants.API_KEY_AISWEB}&apiPass=${Constants.API_PASS_AISWEB}&area=sol")
    @Xml
    suspend fun getSunsetDay(
        @Query("icaoCode") icaoCode: String,
        @Query("dt_i") startDate: String? = null,
        @Query("dt_f") endDate: String? = null
    ): Response<SunriseDayResponse>
}
