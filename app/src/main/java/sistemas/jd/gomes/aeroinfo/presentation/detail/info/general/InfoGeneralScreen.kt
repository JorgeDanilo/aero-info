package sistemas.jd.gomes.aeroinfo.presentation.detail.info.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import sistemas.jd.gomes.aeroinfo.data.model.Notam
import sistemas.jd.gomes.aeroinfo.presentation.component.ErrorScreen
import sistemas.jd.gomes.aeroinfo.presentation.component.LoadingProgressBar
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary
import sistemas.jd.gomes.aeroinfo.util.DateUtil
import sistemas.jd.gomes.aeroinfo.util.ResourceState

@Composable
fun InfoGeneralScreen(
    infoViewModel: InfoViewModel = hiltViewModel()
) {

    val result by infoViewModel.notam.collectAsState()

    when (result) {
        is ResourceState.Success -> {
            InfoGeneralContent(result.data)
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
fun InfoGeneralContent(data: Notam?) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.BlueDark,
        contentColor = Color.White,
        topBar = {

        },
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
                        text = "Notam",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Spacer(Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 50.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "NOTAMs", color = MaterialTheme.colors.GrayPrimary)

                    data?.notamItem?.forEach { notamItem ->
                        Row {
                            Box(
                                modifier = Modifier
                                    .background(color = Color.Blue)
                                    .padding(all = 5.dp)
                            ) {
                                Text(
                                    text = notamItem.category,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .background(color = Color.Blue)
                                    .padding(all = 5.dp)
                            ) {
                                Text(
                                    text = notamItem.number,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            Text(
                                modifier = Modifier.padding(all = 5.dp),
                                text = "Emitido em ${notamItem.datePublished}",
                                color = MaterialTheme.colors.GrayPrimary,
                                fontStyle = FontStyle.Italic,
                                fontSize = 12.sp
                            )
                        }

                        Row {
                            Text(
                                text = notamItem.informationNotam,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row {
                            Icon(
                                Icons.Default.DateRange,
                                contentDescription = null
                            )
                            Text(
                                "${DateUtil.formatDate(notamItem.startDateEffective)} → ${
                                    DateUtil.formatDate(
                                        notamItem.endDateEffective
                                    )
                                } UTC"
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    )
}