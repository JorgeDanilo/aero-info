package sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import sistemas.jd.gomes.aeroinfo.DetailPdfActivity
import sistemas.jd.gomes.aeroinfo.data.model.Chart
import sistemas.jd.gomes.aeroinfo.presentation.component.LoadingProgressBar
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.util.ResourceState
import sistemas.jd.gomes.aeroinfo.util.SearchDTO


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfoCharts(
    infoChartsViewModel: ChartsViewModel = hiltViewModel()
) {

    val chatsInfoResult by infoChartsViewModel.chartsInfo.collectAsState()
    val chatResponseStream by infoChartsViewModel.downloadChart.collectAsState()
    val context = LocalContext.current

    when (chatResponseStream) {
        is ResourceState.Success -> {
            val intent = Intent(context, DetailPdfActivity::class.java)
            SearchDTO.inputStreamChart = chatResponseStream.data
            context.startActivity(intent)
        }
        is ResourceState.Loading -> {
            LoadingProgressBar()
        }
        is ResourceState.Error -> {
            Box(modifier = Modifier.fillMaxSize(),
                content = {
                    Text(text = chatResponseStream.message!!)
                }
            )
        }
        else -> {}
    }

    when (chatsInfoResult) {
        is ResourceState.Success -> {
            InfoChartContents(chatsInfoResult.data, infoChartsViewModel)
        }
        is ResourceState.Loading -> {
            LoadingProgressBar()
        }
        is ResourceState.Error -> {

        }
        else -> {}
    }
}

@Composable
fun InfoChartContents(chart: Chart?, viewModel: ChartsViewModel) {
    chart?.itemChart?.sortBy { it.type }
    Scaffold(
        backgroundColor = MaterialTheme.colors.BlueDark,
        contentColor = Color.White,
        content = {
            Divider(
                modifier = Modifier
                    .heightIn(290.dp)
                    .background(MaterialTheme.colors.BlueDark)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 8.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Row {
                    Text(
                        text = "Cartas",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Spacer(Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 50.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    chart?.itemChart?.forEach { itemChart ->
                        Text(text = itemChart.type?.name!!)
                        Button(
                            onClick = {
                                openChart(itemChart.id, viewModel)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = itemChart.nome)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    )
}


fun openChart(fileId: String, viewModel: ChartsViewModel) {
    viewModel.downloadChart(fileId)
}


