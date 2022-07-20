package sistemas.jd.gomes.aeroinfo.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import sistemas.jd.gomes.aeroinfo.R

@Composable
fun DirectionWindRunway(
    runwayDirection: Float,
    windDirection: Float,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {

        Image(
            painterResource(R.drawable.ic_get_runway),
            contentDescription = "",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .rotate(runwayDirection)
        )

        Image(
            painterResource(R.drawable.ic_compass_arrow),
            contentDescription = "",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .rotate(windDirection)
        )
    }
}
