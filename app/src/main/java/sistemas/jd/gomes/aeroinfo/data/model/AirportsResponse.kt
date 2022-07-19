package sistemas.jd.gomes.aeroinfo.data.model

import com.google.gson.annotations.SerializedName

data class AirportsResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val airports: List<Airport>
)
