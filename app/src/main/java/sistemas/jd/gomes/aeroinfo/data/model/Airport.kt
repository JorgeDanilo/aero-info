package sistemas.jd.gomes.aeroinfo.data.model

import com.google.gson.annotations.SerializedName

data class Airport(
    @SerializedName("id")
    val id: Long,

    @SerializedName("cod")
    val cod: String,

    @SerializedName("nome")
    val name: String,

    @SerializedName("cidade")
    val city: String,
)
