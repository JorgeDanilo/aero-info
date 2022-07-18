package sistemas.jd.gomes.aeroinfo.data.model

data class AirportDto(
    var localidade: String,
    var nome: String,
    var cidade: String,
    var longitude: String,
    var latitude: String,
    var localizacao: String,
    var metar: String,
    var taf: String,
    var data: String,
    var temperatura: String,
    var umidadeRelativa: String,
    var visibilidade: String,
    var teto: String,
    var ceu: String,
    var condicoesTempo: String,
    var vento: String,
    var sunsetDays: MutableList<SunriseDay> = mutableListOf()
)