package sistemas.jd.gomes.aeroinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sistemas.jd.gomes.aeroinfo.data.model.RotaerResponse
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.Xml

interface RotaerApi {

    @GET("${Constants.BASE_URL_AISWEB}/?apiKey=${Constants.API_KEY_AISWEB}&apiPass=${Constants.API_PASS_AISWEB}&area=rotaer")
    @Xml
    suspend fun getRotaer(
        @Query("icaoCode") icaoCode: String
    ): Response<RotaerResponse>
}