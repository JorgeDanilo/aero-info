package sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import sistemas.jd.gomes.aeroinfo.R

@Composable
fun InfoRotaer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize()
    ) {

        Image(
            painterResource(R.drawable.ic_get_runway),
            contentDescription = "",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .rotate(130f)
        )

        Image(
            painterResource(R.drawable.ic_compass_arrow),
            contentDescription = "",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .rotate(30f)
        )
    }
}