package sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import sistemas.jd.gomes.aeroinfo.data.model.Chart
import sistemas.jd.gomes.aeroinfo.data.model.ChartResponse
import sistemas.jd.gomes.aeroinfo.repository.ChartsRepository
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import sistemas.jd.gomes.aeroinfo.util.SearchDTO
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class ChartsViewModel @Inject constructor(
    private val chartsRepository: ChartsRepository
) : ViewModel() {

    private val _chartsInfo = MutableStateFlow<ResourceState<Chart>>(ResourceState.Empty())
    val chartsInfo: StateFlow<ResourceState<Chart>> = _chartsInfo

    private val _downloadChart =
        MutableStateFlow<ResourceState<InputStream>>(ResourceState.Empty())
    val downloadChart: StateFlow<ResourceState<InputStream>> = _downloadChart

    init {
        viewModelScope.launch {
            _chartsInfo.value = ResourceState.Loading()
            try {
                val response = chartsRepository.getCharts(SearchDTO.icaoCode)
                _chartsInfo.value = handleResponse(response)
            } catch (t: Throwable) {
                when (t) {
                    is IOException -> _chartsInfo.value =
                        ResourceState.Error("Erro de conexão!")
                    else -> _chartsInfo.value =
                        ResourceState.Error("Ops, aconteceu algum erro tente novamente!")
                }
            }
        }
    }

    private fun handleResponse(response: Response<ChartResponse>): ResourceState<Chart> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return ResourceState.Success(values.charts!!)
            }
        }
        return ResourceState.Error(response.message())
    }

    fun downloadChart(fileId: String) {
        _downloadChart.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                val response = chartsRepository.downloadCharts(fileId)
                _downloadChart.value = handleResponseBody(response)
            } catch (e: Exception) {
                when (e) {
                    is IOException -> _downloadChart.value = ResourceState.Error("Erro de conexão!")
                    else -> _downloadChart.value =
                        ResourceState.Error("Ops, aconteceu algum erro tente novamente!")
                }
            }
        }
    }

    private fun handleResponseBody(response: Response<ResponseBody>): ResourceState<InputStream> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return ResourceState.Success(values.byteStream())
            }
        }
        return ResourceState.Error(response.message())
    }
}