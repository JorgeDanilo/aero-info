package sistemas.jd.gomes.aeroinfo.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AirportInfoResponse(
    @SerializedName("status")
    var status: Boolean,

    @SerializedName("message")
    var message: String?,

    @SerializedName("data")
    var data: AirfieldsInfo
)
