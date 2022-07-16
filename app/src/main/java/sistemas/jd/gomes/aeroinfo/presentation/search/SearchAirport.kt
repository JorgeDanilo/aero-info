package sistemas.jd.gomes.aeroinfo.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ListAirport(
//    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.metar_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }

            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchAirports(query = it)
                },
                onCloseClicked = {
//                    navController.popBackStack()
                }
            )
            ListAirportContent(searchViewModel)
        }
    )
}

@Composable
fun ListAirportContent(viewModel: SearchViewModel) {
    val airports = viewModel.airports.collectAsState()
    Column(
        modifier = Modifier
            .padding(top = 150.dp, bottom = 8.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        when (airports.value) {
            is ResourceState.Success -> {
                val result = airports.value.data
                if (!result?.data.isNullOrEmpty()) {
                    result?.data?.forEach {
                        ListAirportItem(it)
                    }
                }
            }
            is ResourceState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            is ResourceState.Error -> {
                airports.value.data?.message.let { message ->

                }
            }
            else -> {}
        }
    }
}

@Composable
fun ListAirportItem(airport: List<String>) {
    Card(
        backgroundColor = MaterialTheme.colors.GrayDark,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 12.dp, end = 12.dp)
            .height(330.dp)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Row {

                if (airport[4] == "g") {
                    Card(
                        shape = CircleShape,
                        backgroundColor = Color.Green,
                        modifier = Modifier.padding(top = 5.dp, end = 5.dp)
                    ) {
                        Divider(
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                        )
                    }
                } else if (airport[4] == "y") {
                    Card(
                        shape = CircleShape,
                        backgroundColor = Color.Yellow,
                        modifier = Modifier.padding(top = 5.dp, end = 5.dp)
                    ) {
                        Divider(
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                        )
                    }
                } else if (airport[4] == "r") {
                    Card(
                        shape = CircleShape,
                        backgroundColor = Color.Red,
                        modifier = Modifier.padding(top = 5.dp, end = 5.dp)
                    ) {
                        Divider(
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                        )
                    }
                }


                Text(
                    text = airport[0],
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier =
                    Modifier.padding(start = 5.dp)
                )

                Text(
                    text = airport[1],
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.padding(start = 30.dp))

//                if (airport[4] == "g") {
//                    Box(
//                        modifier = Modifier
//                            .background(color = Color.Green)
//                            .padding(all = 5.dp)
//                    ) {
//                        Text(
//                            text = "VRF",
//                            fontWeight = FontWeight.Bold,
//                            color = MaterialTheme.colors.BlueDark
//                        )
//                    }
//                } else if (airport[4] == "r") {
//                    Box(
//                        modifier = Modifier
//                            .background(color = Color.Red)
//                            .padding(all = 5.dp)
//                    ) {
//                        Text(
//                            text = "IFR",
//                            fontWeight = FontWeight.Bold,
//                            color = MaterialTheme.colors.BlueDark
//                        )
//                    }
//                }

            }
            Row {
                Icon(
                    Icons.Filled.DateRange,
                    tint = MaterialTheme.colors.GrayPrimary,
                    contentDescription = null,
                )
                Text(
                    text = timeNow(),
                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                )

//                Spacer(modifier = Modifier.padding(start = 6.dp))
//
//                Icon(
//                    Icons.Default.AirplaneTicket,
//                    tint = MaterialTheme.colors.GrayPrimary,
//                    contentDescription = null,
//                )
//
//                Text(
//                    text = "230/3KT",
//                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
//                )
//
//                Spacer(modifier = Modifier.padding(start = 6.dp))
//
//                Icon(
//                    Icons.Default.Thermostat,
//                    tint = MaterialTheme.colors.GrayPrimary,
//                    contentDescription = null,
//                )
//                Text(
//                    text = "16ºC",
//                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
//                )
//
//                Spacer(modifier = Modifier.padding(start = 6.dp))
//
//                Icon(
//                    Icons.Default.Speed,
//                    tint = MaterialTheme.colors.GrayPrimary,
//                    contentDescription = null,
//                )
//                Text(
//                    text = "1013",
//                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
//                )
            }

            Row(Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Visibilidade:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                if (airport[4] == "g") {
                    Text(
                        text = ">= 5000m",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                } else if (airport[4] == "y") {
                    Text(
                        text = "< 5000 e >= 1500m",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                } else if (airport[4] == "r") {
                    Text(
                        text = "< 1500",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                }

            }

            Row(modifier = Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Teto:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                if (airport[4] == "g") {
                    Text(
                        text = ">= 1500m",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                } else if (airport[4] == "y") {
                    Text(
                        text = "< 1500 e > 500",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                } else if (airport[4] == "r") {
                    Text(
                        text = "< 600",
                        modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                    )
                }
            }

//            Row(modifier = Modifier.padding(top = 5.dp)) {
//                Text(
//                    text = "Condições:",
//                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
//                    fontWeight = FontWeight.Bold
//                )
//
//                Text(
//                    text = "Sem tempo significativo",
//                    modifier = Modifier.padding(start = 5.dp, top = 2.dp),
//                )
//            }

            Text(
                text = "º ${airport[5]}",
                modifier = Modifier
                    .padding(start = 2.dp, top = 2.dp)
                    .padding(top = 5.dp),
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview
@Composable
fun screenAirport() {
    ListAirportItem(emptyList())
}

fun timeNow(): String {
    val c: Calendar = Calendar.getInstance()
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    return sdf.format(c.time)
}