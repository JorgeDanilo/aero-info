package sistemas.jd.gomes.aeroinfo.presentation.search

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.presentation.Screen
import sistemas.jd.gomes.aeroinfo.presentation.component.ErrorScreen
import sistemas.jd.gomes.aeroinfo.presentation.component.LoadingProgressBar
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.util.ResourceState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchAirportScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.BlueDark
    val keyboardController = LocalSoftwareKeyboardController.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.BlueDark,
        contentColor = Color.White,
        topBar = {

        },
        content = {
            Divider(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.BlueDark)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 15.dp),
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
                    searchViewModel.searchAirports(query = it).apply {
                        keyboardController?.hide()
                    }
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
            ListAirportContent(searchViewModel, navController)
        }
    )
}

@Composable
fun ListAirportContent(viewModel: SearchViewModel, navController: NavHostController) {
    val airports = viewModel.airports.collectAsState()
    Column(
        modifier = Modifier
            .padding(top = 170.dp, bottom = 5.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        when (airports.value) {
            is ResourceState.Success -> {
                val result = airports.value.data
                if (!result?.data.isNullOrEmpty()) {
                    result?.data?.forEach {
                        ListAirportItem(it, navController)
                    }
                }
            }
            is ResourceState.Loading -> {
                LoadingProgressBar(color = Color.White)
            }

            is ResourceState.Error -> {
                ErrorScreen(message = airports.value.data?.message)
            }
            else -> {}
        }
    }
}

@Composable
fun ListAirportItem(
    infoAirport: List<String>,
    navController: NavHostController
) {
    Card(
        backgroundColor = MaterialTheme.colors.BlueDark,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, start = 6.dp, end = 6.dp)
            .height(250.dp)
    ) {
        Column(modifier = Modifier
            .padding(all = 6.dp)
            .clickable {
                navController.navigate(Screen.Details.passIcaoCode(icaoCode = infoAirport[0]))
            }) {
            Row {
                when {
                    infoAirport[4] == "g" -> {
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
                    }
                    infoAirport[4] == "y" -> {
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
                    }
                    infoAirport[4] == "r" -> {
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
                }


                Text(
                    text = infoAirport[0],
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier =
                    Modifier.padding(start = 5.dp)
                )

                Text(
                    text = infoAirport[1],
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.padding(start = 30.dp))
            }

            Row(Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Visibilidade:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                when {
                    infoAirport[4] == "g" -> {
                        Text(
                            text = ">= 5000m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                    infoAirport[4] == "y" -> {
                        Text(
                            text = "< 5000 e >= 1500m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                    infoAirport[4] == "r" -> {
                        Text(
                            text = "< 1500m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                }

            }

            Row(modifier = Modifier.padding(top = 5.dp)) {
                Text(
                    text = "Teto:",
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                    fontWeight = FontWeight.Bold
                )

                when {
                    infoAirport[4] == "g" -> {
                        Text(
                            text = ">= 1500m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                    infoAirport[4] == "y" -> {
                        Text(
                            text = "< 1500m e > 500m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                    infoAirport[4] == "r" -> {
                        Text(
                            text = "< 600m",
                            modifier = Modifier.padding(start = 5.dp, top = 2.dp),
                        )
                    }
                }
            }

            Text(
                text = infoAirport[5],
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 2.dp, top = 2.dp)
            )
        }
    }
}