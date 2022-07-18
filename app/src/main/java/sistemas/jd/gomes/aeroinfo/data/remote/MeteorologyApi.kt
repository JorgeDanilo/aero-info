package sistemas.jd.gomes.aeroinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sistemas.jd.gomes.aeroinfo.data.model.MeteorologyResponse
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.Constants.API_KEY_AISWEB
import sistemas.jd.gomes.aeroinfo.util.Constants.API_PASS_AISWEB
import sistemas.jd.gomes.aeroinfo.util.Xml

interface MeteorologyApi {

    @GET("${Constants.BASE_URL_AISWEB}/?apiKey=$API_KEY_AISWEB&apiPass=$API_PASS_AISWEB&area=met")
    @Xml
    suspend fun getMeteorology(
        @Query("icaoCode") icaoCode: String
    ): Response<MeteorologyResponse>
}