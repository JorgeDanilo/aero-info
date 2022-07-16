package sistemas.jd.gomes.aeroinfo.presentation.detail.info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import sistemas.jd.gomes.aeroinfo.data.model.AirportInfoResponse
import sistemas.jd.gomes.aeroinfo.repository.AiportRepository
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: AiportRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _infoAirport =
        MutableStateFlow<ResourceState<AirportInfoResponse>>(ResourceState.Empty())
    val infoAirport: StateFlow<ResourceState<AirportInfoResponse>> = _infoAirport

    init {
        _infoAirport.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                val response = repository.getDetail("sbgo")
                _infoAirport.value = handleResponse(response)
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

    private fun handleResponse(response: Response<AirportInfoResponse>): ResourceState<AirportInfoResponse> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return ResourceState.Success(values)
            }
        }
        return ResourceState.Error(response.message())
    }
}