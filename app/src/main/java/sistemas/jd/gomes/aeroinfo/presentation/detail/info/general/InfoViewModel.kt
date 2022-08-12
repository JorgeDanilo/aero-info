package sistemas.jd.gomes.aeroinfo.presentation.detail.info.general

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import sistemas.jd.gomes.aeroinfo.data.model.Notam
import sistemas.jd.gomes.aeroinfo.data.model.NotamResponse
import sistemas.jd.gomes.aeroinfo.repository.NotamRepository
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import sistemas.jd.gomes.aeroinfo.util.SearchDTO
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val notamRepository: NotamRepository
) : ViewModel() {

    private val _notam = MutableStateFlow<ResourceState<Notam>>(ResourceState.Empty())
    var notam: StateFlow<ResourceState<Notam>> = _notam

    init {
        _notam.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                val response = notamRepository.getNotam(SearchDTO.icaoCode)
                _notam.value = handleResponse(response)
            } catch (e: Exception) {
                when (e) {
                    is IOException -> _notam.value =
                        ResourceState.Error("Erro de conexão!")
                    else -> _notam.value =
                        ResourceState.Error("Ops, aconteceu algum erro tente novamente!")
                }
            }
        }
    }

    private fun handleResponse(response: Response<NotamResponse>): ResourceState<Notam> {
        if (response.isSuccessful) {
            response.body()?.notam?.let { values ->
                return ResourceState.Success(values)
            }
        }
        return ResourceState.Error(response.message())
    }
}