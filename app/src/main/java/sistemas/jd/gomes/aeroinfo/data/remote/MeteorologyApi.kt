package sistemas.jd.gomes.aeroinfo.data.remote

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming
import sistemas.jd.gomes.aeroinfo.data.model.MeteorologyResponse
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.Constants.API_KEY_AISWEB
import sistemas.jd.gomes.aeroinfo.util.Constants.API_KEY_REDMET
import sistemas.jd.gomes.aeroinfo.util.Constants.API_PASS_AISWEB
import sistemas.jd.gomes.aeroinfo.util.Json
import sistemas.jd.gomes.aeroinfo.util.Xml
import java.util.*

interface MeteorologyApi {

    @GET("${Constants.BASE_URL_AISWEB}/?apiKey=$API_KEY_AISWEB&apiPass=$API_PASS_AISWEB&area=met")
    @Xml
    suspend fun getMeteorology(
        @Query("icaoCode") icaoCode: String
    ): Response<MeteorologyResponse>

    @GET("/produtos/sigwx?api_key=${API_KEY_REDMET}")
    @Json
    @Streaming
    suspend fun getChartSigwx(): Response<ResponseBody>
}