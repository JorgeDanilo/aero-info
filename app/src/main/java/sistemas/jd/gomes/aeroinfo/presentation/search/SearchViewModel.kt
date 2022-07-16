package sistemas.jd.gomes.aeroinfo.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import sistemas.jd.gomes.aeroinfo.data.model.AirportInfoResponse
import sistemas.jd.gomes.aeroinfo.data.model.AirportResponse
import sistemas.jd.gomes.aeroinfo.repository.AiportRepository
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val repository: AiportRepository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _airports =
        MutableStateFlow<ResourceState<AirportResponse>>(ResourceState.Empty())
    val airports: StateFlow<ResourceState<AirportResponse>> = _airports


    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchAirports(query: String) {
        _airports.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                val result = repository.list(query.replace(" ", ""))
                _airports.value = handleResponse(result)
            } catch (t: Throwable) {
                when (t) {
                    is IOException -> _airports.value = ResourceState.Error("Erro de conexão!")
                    else -> _airports.value =
                        ResourceState.Error("Ops, aconteceu algum erro tente novamente!")
                }
            }
        }
    }

    private fun handleResponse(response: Response<AirportResponse>): ResourceState<AirportResponse> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return ResourceState.Success(values)
            }
        }
        return ResourceState.Error(response.message())
    }
}