package sistemas.jd.gomes.aeroinfo.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary

@Composable
@Preview
fun ListAirport() {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.GrayPrimary

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.GrayPrimary,
        contentColor = Color.White,
        topBar = {

        },
        content = {
            Divider(
                modifier = Modifier
                    .height(200.dp)
                    .background(MaterialTheme.colors.BlueDark)
                    .clip(RoundedCornerShape(20.dp))
            )
           Column(
               modifier = Modifier.fillMaxWidth().padding(all = 20.dp),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Image(
                   painterResource(R.drawable.metar_icon),
                   contentDescription = "",
                   modifier = Modifier
                       .width(70.dp)
                       .height(70.dp)
               )
           }
            SearchInput()
            ListAirportContent()
        }
    )
}

@Composable
private fun SearchInput() {
    var search by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .background(MaterialTheme.colors.BlueDark)
            .height(100.dp)
    ) {

    }
    TextField(
        value = search,
        onValueChange = {
            search = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = Color.White,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.Close,
                tint = Color.White,
                contentDescription = null
            )
        },
        label = {
            Text(
                "Search Airport",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 12.dp, end = 12.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ListAirportContent() {
    LazyColumn(
        modifier = Modifier.padding(top = 170.dp)
    ) {
        items(10) {
            ListAirportItem()
        }
    }
}

@Composable
fun ListAirportItem() {
    Card(
        backgroundColor = MaterialTheme.colors.GrayDark,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 12.dp, end = 12.dp)
            .height(200.dp)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Row {

                Card(shape = CircleShape, backgroundColor = Color.Green, modifier = Modifier.padding(top = 5.dp, end = 5.dp)) {
                    Divider(modifier = Modifier
                        .height(10.dp)
                        .width(10.dp))
                }

                Text(
                    text = "SBSP",
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier =
                    Modifier.padding(start = 5.dp)
                )

                Text(
                    text = "Aeroporto de Congonhas / São Paulo",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.padding(start = 30.dp))

                Box(
                    modifier = Modifier
                        .background(color = Color.Green)
                        .padding(all = 5.dp)
                ) {
                    Text(
                        text = "VRF",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.BlueDark
                    )
                }
            }
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
                    text = "1013",
                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                )
            }

            Row(Modifier.padding(top = 5.dp)) {
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

            Row(modifier = Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Umidade Relativa:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "87%",
                    modifier = Modifier.padding(top = 2.dp, start = 5.dp),
                )
            }

            Row(modifier = Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Condições:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Sem tempo significativo",
                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                )
            }

            Text(
                text = "º METAR SBSP 202300Z 09003KT 060V130 CAVOK 16/14 Q1022=",
                modifier = Modifier
                    .padding(start = 2.dp, top = 2.dp)
                    .padding(top = 5.dp),
                fontStyle = FontStyle.Italic
            )
        }
    }
}
