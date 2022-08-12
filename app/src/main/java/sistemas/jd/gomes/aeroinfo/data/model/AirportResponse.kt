package sistemas.jd.gomes.aeroinfo.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AirportResponse(
    @SerializedName("data")
    val `data`: List<List<String>>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)
