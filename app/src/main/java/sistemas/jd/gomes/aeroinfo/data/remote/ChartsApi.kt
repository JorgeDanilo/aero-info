package sistemas.jd.gomes.aeroinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sistemas.jd.gomes.aeroinfo.data.model.ChartResponse
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.Xml

interface ChartsApi {

    @GET("${Constants.BASE_URL_AISWEB}/?apiKey=${Constants.API_KEY_AISWEB}&apiPass=${Constants.API_PASS_AISWEB}&area=cartas")
    @Xml
    suspend fun getCharts(
        @Query("icaoCode") icaoCode: String
    ): Response<ChartResponse>
}