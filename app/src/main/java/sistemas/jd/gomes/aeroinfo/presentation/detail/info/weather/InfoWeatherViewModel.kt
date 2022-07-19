package sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import sistemas.jd.gomes.aeroinfo.data.model.AirportDto
import sistemas.jd.gomes.aeroinfo.data.model.AirportInfoResponse
import sistemas.jd.gomes.aeroinfo.data.model.MeteorologyResponse
import sistemas.jd.gomes.aeroinfo.data.model.SunriseDayResponse
import sistemas.jd.gomes.aeroinfo.repository.AiportRepository
import sistemas.jd.gomes.aeroinfo.repository.MetereolgyRepository
import sistemas.jd.gomes.aeroinfo.repository.SunsetDayRepository
import sistemas.jd.gomes.aeroinfo.util.DateUtil.formatDateToJson
import sistemas.jd.gomes.aeroinfo.util.DateUtil.now
import sistemas.jd.gomes.aeroinfo.util.DateUtil.sumDays
import sistemas.jd.gomes.aeroinfo.util.DateUtil.timeNowToJson
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import sistemas.jd.gomes.aeroinfo.util.SearchDTO
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class InfoWeatherViewModel @Inject constructor(
    private val aiportRepository: AiportRepository,
    private val metereolgyRepository: MetereolgyRepository,
    private val sunsetDayRepository: SunsetDayRepository
) : ViewModel() {

    private val _infoAirport =
        MutableStateFlow<ResourceState<AirportDto>>(ResourceState.Empty())
    val infoAirport: StateFlow<ResourceState<AirportDto>> = _infoAirport

    init {
        _infoAirport.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                val airportResponse = aiportRepository.getDetail(SearchDTO.icaoCode)
                val meteorologyResponse = metereolgyRepository.getMeteorology(SearchDTO.icaoCode)
                val sunsetResponse = sunsetDayRepository.getSunsetDay(
                    SearchDTO.icaoCode, timeNowToJson(), formatDateToJson(sumDays(now(), 3))
                )
                _infoAirport.value =
                    handleAirportResponse(airportResponse, meteorologyResponse, sunsetResponse)
            } catch (t: Throwable) {
                when (t) {
                    is IOException -> _infoAirport.value =
                        ResourceState.Error("Erro de conexão!")
                    else -> _infoAirport.value =
                        ResourceState.Error("Ops, aconteceu algum erro tente novamente!")
                }
            }
        }
    }

    // TODO: melhorar forma de fazer o map para o dto.
    private fun handleAirportResponse(
        airportInfoResponse: Response<AirportInfoResponse>,
        meteorologyResponse: Response<MeteorologyResponse>,
        sunsetResponse: Response<SunriseDayResponse>
    ): ResourceState<AirportDto> {
        if (airportInfoResponse.isSuccessful && meteorologyResponse.isSuccessful && sunsetResponse.isSuccessful) {
            val response = AirportDto(
                airportInfoResponse.body()?.data?.localidade!!,
                airportInfoResponse.body()?.data?.nome!!,
                airportInfoResponse.body()?.data?.cidade!!,
                airportInfoResponse.body()?.data?.longitude!!,
                airportInfoResponse.body()?.data?.latitude!!,
                airportInfoResponse.body()?.data?.localizacao!!,
                airportInfoResponse.body()?.data?.metar!!,
                meteorologyResponse.body()?.meteoroly?.taf!!,
                airportInfoResponse.body()?.data?.data!!,
                airportInfoResponse.body()?.data?.temperatura!!,
                airportInfoResponse.body()?.data?.umidadeRelativa!!,
                airportInfoResponse.body()?.data?.visibilidade!!,
                airportInfoResponse.body()?.data?.teto!!,
                airportInfoResponse.body()?.data?.ceu!!,
                airportInfoResponse.body()?.data?.condicoesTempo!!,
                airportInfoResponse.body()?.data?.vento!!,
                sunsetResponse.body()?.sunriseDays!!
            )
            return ResourceState.Success(response)
        }
        return ResourceState.Error(airportInfoResponse.message() + meteorologyResponse.message())
    }
}