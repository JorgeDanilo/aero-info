package sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import sistemas.jd.gomes.aeroinfo.data.model.AirportDto
import sistemas.jd.gomes.aeroinfo.presentation.component.DirectionWindRunway
import sistemas.jd.gomes.aeroinfo.presentation.component.ErrorScreen
import sistemas.jd.gomes.aeroinfo.presentation.component.LoadingProgressBar
import sistemas.jd.gomes.aeroinfo.presentation.extensions.getPressure
import sistemas.jd.gomes.aeroinfo.presentation.extensions.getRunwayDirection
import sistemas.jd.gomes.aeroinfo.presentation.extensions.getWindDirection
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary
import sistemas.jd.gomes.aeroinfo.util.ResourceState

@Composable
fun InfoWeatherScreen(
    infoWeatherViewModel: InfoWeatherViewModel = hiltViewModel()
) {
    val result by infoWeatherViewModel.infoAirport.collectAsState()
    when (result) {
        is ResourceState.Success -> {
            result.data?.let { InfoContent(it) }
        }
        is ResourceState.Loading -> {
            LoadingProgressBar()
        }

        is ResourceState.Error -> {
            ErrorScreen(message = result.message)
        }
        else -> {}
    }
}

@Composable
private fun InfoContent(airportInfo: AirportDto) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.BlueDark,
        contentColor = Color.White,
        topBar = {

        },
        content = {
            Divider(
                modifier = Modifier
                    .height(350.dp)
                    .background(MaterialTheme.colors.BlueDark)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 50.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Row {
                    Text(
                        text = airportInfo.nome,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Text(
                    text = airportInfo.localizacao,
                    color = Color.Gray,
                )

                Spacer(Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "INFORMAÇÕES",
                        color = MaterialTheme.colors.GrayPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )

                    Row {
                        Icon(
                            Icons.Filled.DateRange,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = airportInfo.data,
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.AirplaneTicket,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = airportInfo.vento,
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.Speed,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = airportInfo.metar.getPressure().toString(),
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )

                        Icon(
                            Icons.Default.Thermostat,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = airportInfo.temperatura,
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }

                    Row {
                        Text(
                            text = "Visibilidade:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.visibilidade,
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }

                    Row {

                        Text(
                            text = "Teto:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.teto,
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }

                    Row {

                        Text(
                            text = "Umidade Relativa:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.umidadeRelativa,
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )

                        Spacer(modifier = Modifier.padding(start = 6.dp))

                        Text(
                            text = "Ceú:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.ceu,
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )
                    }

                    Row {
                        Text(
                            text = "Condições:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.condicoesTempo,
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )
                    }

                    Row {
                        Text(
                            text = "Sol:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = airportInfo.sunsetDays[0].sunrise,
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )
                        Text(
                            text = airportInfo.sunsetDays[0].sunset,
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Text(
                            text = "METAR",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Text(
                            text = "- ${airportInfo.metar}",
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Text(
                            text = "TAF",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Text(
                            text = "- ${airportInfo.taf}",
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Text(
                            text = "NASCER E PÔR DO SOL",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        Text(
                            text = "Data",
                            color = MaterialTheme.colors.GrayPrimary,
                        )

                        Text(
                            text = "UTC",
                            color = MaterialTheme.colors.GrayPrimary,
                            modifier = Modifier.padding(start = 100.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    airportInfo.sunsetDays.forEach {
                        Row {
                            Text(text = it.dateSunrise)

                            Text(
                                text = it.sunrise,
                                modifier = Modifier.padding(start = 20.dp)
                            )

                            Icon(
                                Icons.Rounded.WbSunny,
                                contentDescription = null
                            )

                            Text(
                                text = it.sunset,
                            )
                        }
                    }

                    if (airportInfo.metar.getWindDirection() != "VRB") {
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "DIREÇÃO DO VENTO",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontWeight = FontWeight.Bold
                        )

                        Row {
                            DirectionWindRunway(
                                airportInfo.runwayDirection.getRunwayDirection().toFloat(),
                                airportInfo.metar.getWindDirection().toFloat()
                            )
                        }
                    }
                }
            }
        }
    )
}