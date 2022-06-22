package sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark


@Composable
fun InfoCharts() {
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
                    .fillMaxWidth()
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
                    Text(text = "ADC")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "ADC SBSP")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "AOC")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "AD 2 SBSP A")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "IAC")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "IAC ILS R OU/OR LOC R RWR 3L")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "ILS V RWY 35L")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "ILS X RWY 17 R")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "ILS Y OR LOC Y RWY 17R")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "RNP S RWY 35R")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "RNP T RWY 17L")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "RNP X RWY 35L (AR)")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "RNP Y RWY 17R")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "RNP Z RWY 35L")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "VOR Y RWY 35L/35R" )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "VOR Z RWY 17L/17R" )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "PDC")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "PDC SBSP" )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "SID")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "OMNI RWY 17L/17R 35L/35R" )
                    }

                }
            }
        }
    )
}

@Composable
@Preview
private fun ShowView() {
    InfoCharts()
}
