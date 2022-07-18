package sistemas.jd.gomes.aeroinfo.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "airfields")
data class AirfieldsInfo(
    @SerializedName("localidade")
    var localidade: String,

    @SerializedName("nome")
    var nome: String,

    @SerializedName("cidade")
    var cidade: String,

    @SerializedName("lon")
    var longitude: String,

    @SerializedName("lat")
    var latitude: String,

    @SerializedName("localizacao")
    var localizacao: String,

    @SerializedName("metar")
    var metar: String,

    @SerializedName("data")
    var data: String,

    @SerializedName("temperatura")
    var temperatura: String,

    @SerializedName("ur")
    var umidadeRelativa: String,

    @SerializedName("visibilidade")
    var visibilidade: String,

    @SerializedName("teto")
    var teto: String,

    @SerializedName("ceu")
    var ceu: String,

    @SerializedName("condicoes_tempo")
    var condicoesTempo: String,

    @SerializedName("vento")
    var vento: String
)
