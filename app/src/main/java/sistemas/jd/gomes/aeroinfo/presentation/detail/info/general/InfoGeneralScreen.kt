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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayPrimary

@Composable
fun InfoGeneralScreen() {
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
                    .fillMaxWidth()
                    .padding(all = 8.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Row {
                    Text(
                        text = "INFORMAÇÕES GERAIS",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Spacer(Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "FREQUÊNCIAS", color = MaterialTheme.colors.GrayPrimary)

                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        Text(text = "TORRE SÃO PAULO - ", fontWeight = FontWeight.Bold)
                        Text(text = "118.050 / 127.150")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        Text(text = "SOLO SÃO PAULO - ", fontWeight = FontWeight.Bold)
                        Text(text = "121.900")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        Text(text = "TRÁFEGO SÃO PAULO - ", fontWeight = FontWeight.Bold)
                        Text(text = "120.600")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row {
                        Text(text = "ATIS SÃO PAULO - ", fontWeight = FontWeight.Bold)
                        Text(text = "127.650")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "ABASTECIMENTO", color = MaterialTheme.colors.GrayPrimary)

                    Row {
                        Text(text = "PF TF", fontWeight = FontWeight.Bold)
                        Text(text = " - (DLY 0800-0200)", modifier = Modifier.padding(start = 5.dp))
                    }

                    /* NOTAMS */

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "NOTAMs", color = MaterialTheme.colors.GrayPrimary)

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0817/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:23:43",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 13 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "21/06/22 02:00 → 25/06/22 09:00 UTC"
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0818/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:25:27",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 12 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "27/06/22 02:00 → 01/07/22 09:00 UTC"
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0818/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:25:27",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 12 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "27/06/22 02:00 → 01/07/22 09:00 UTC"
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0818/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:25:27",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 12 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "27/06/22 02:00 → 01/07/22 09:00 UTC"
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0818/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:25:27",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 12 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "27/06/22 02:00 → 01/07/22 09:00 UTC"
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Blue)
                                .padding(all = 5.dp)
                        ) {
                            Text(
                                text = "AGA",
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
                                text = "D0818/22",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = "Emitido em 2022-05-24 13:25:27",
                            color = MaterialTheme.colors.GrayPrimary,
                            fontStyle = FontStyle.Italic,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "TWY NOVEMBER E MIKE CLSD NO TRAVES DA PSN 12 DEVIDO OBRAS",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                        Text(
                            "27/06/22 02:00 → 01/07/22 09:00 UTC"
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
    InfoGeneralScreen()
}

