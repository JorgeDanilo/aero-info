package sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary

@Composable
fun InfoWeather() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.BlueDark,
        contentColor = Color.White,
        topBar = {

        },
        content = {
            Divider(
                modifier = Modifier
                    .height(290.dp)
                    .background(MaterialTheme.colors.BlueDark)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Row {
                    Card(
                        shape = CircleShape,
                        backgroundColor = Color.Green,
                        modifier = Modifier.padding(top = 10.dp, end = 5.dp)
                    ) {
                        Divider(
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                        )
                    }
                    Text(
                        text = "Aeroporto de Congonhas / SP",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
                Text(
                    text = "º 23º32'37'' / 46º39'79''",
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
                            text = "20/06",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )

                        Spacer(modifier = Modifier.padding(start = 6.dp))

                        Icon(
                            Icons.Default.AirplaneTicket,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = "230/3KT",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )

                        Spacer(modifier = Modifier.padding(start = 6.dp))

                        Icon(
                            Icons.Default.Thermostat,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = "16ºC",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )

                        Spacer(modifier = Modifier.padding(start = 6.dp))

                        Icon(
                            Icons.Default.Speed,
                            tint = MaterialTheme.colors.GrayPrimary,
                            contentDescription = null,
                        )
                        Text(
                            text = "1013 hpa",
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
                            text = "Maior ou igual à 10km.",
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
                            text = "Não há formação.",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )

                        Text(
                            text = "Umidade Relativa:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "53%",
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )
                    }

                    Row {

                        Text(
                            text = "Ceú:",
                            modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Com poucas Nuvens",
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
                            text = "Sem tempo significativo",
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
                            text = "09:48",
                            modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                        )

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )
                        Text(
                            text = "20:28",
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
                            text = "- METAR SBSP 212000Z 34006KT 9999 FEW046 24/14 Q1019=",
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
                            text = "- TAF SBSP 211600Z 2118Z 2118/2206 35008KT CAVOK \n " +
                                    "TX26/2118Z TN16/2206Z \n" +
                                    "º TEMPO 2119/2124 16005KT\n" +
                                    "º BECMG 2200/2202 03005KT RMK PHG =",
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

                        Text(
                            text = "Local",
                            color = MaterialTheme.colors.GrayPrimary,
                            modifier = Modifier.padding(start = 100.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Text(text = "19/06/2022")

                        Text(
                            text = "10:19",
                            modifier = Modifier.padding(start = 20.dp)
                        )

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "20:32",
                        )

                        Text(text = "17:32", modifier = Modifier.padding(start = 40.dp))

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "17:32",
                        )

                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Text(text = "20/06/2022")

                        Text(
                            text = "10:19",
                            modifier = Modifier.padding(start = 20.dp)
                        )

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "20:32",
                        )

                        Text(text = "17:32", modifier = Modifier.padding(start = 40.dp))

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "17:32",
                        )

                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {

                        Text(text = "21/06/2022")

                        Text(
                            text = "10:20",
                            modifier = Modifier.padding(start = 20.dp),
                        )

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "20:23",
                            fontWeight = FontWeight.Bold
                        )

                        Text(text = "07:20", modifier = Modifier.padding(start = 40.dp))

                        Icon(
                            Icons.Rounded.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = "17:33",
                        )

                    }


                }
            }
        }
    )
}

@Composable
@Preview
private fun ShowScreen() {
    InfoWeather()
}