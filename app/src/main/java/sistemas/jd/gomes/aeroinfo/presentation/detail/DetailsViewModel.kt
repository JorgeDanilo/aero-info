package sistemas.jd.gomes.aeroinfo.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sistemas.jd.gomes.aeroinfo.util.Constants
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getIcaoCode(): String {
        return savedStateHandle.get<String>(Constants.DETAILS_ARGUMENT_KEY) ?: ""
    }
}