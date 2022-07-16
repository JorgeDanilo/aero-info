package sistemas.jd.gomes.aeroinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sistemas.jd.gomes.aeroinfo.data.model.AirportInfoResponse
import sistemas.jd.gomes.aeroinfo.data.model.AirportResponse
import sistemas.jd.gomes.aeroinfo.util.Constants.API_KEY

interface AirportApi {

    @GET("/aerodromos/status/localidades/{localidadeId}?api_key=$API_KEY")
    suspend fun searchAirports(
        @Path("localidadeId") icaoCode: String? = null
    ): Response<AirportResponse>

    @GET("/aerodromos/info?api_key=$API_KEY")
    suspend fun getDetailAirports(
        @Query("localidade") icaoCode: String
    ): Response<AirportInfoResponse>
}