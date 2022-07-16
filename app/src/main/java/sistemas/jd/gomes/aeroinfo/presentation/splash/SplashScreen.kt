package sistemas.jd.gomes.aeroinfo.presentation.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.Screen
import sistemas.jd.gomes.aeroinfo.ui.theme.Purple500
import sistemas.jd.gomes.aeroinfo.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.navigate(Screen.Search.route)
    }
    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {
    Box(
        modifier = Modifier
            .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .rotate(degrees = degrees)
                .width(100.dp)
                .height(100.dp),
            painter = painterResource(id = R.drawable.metar_icon),
            contentDescription = ""
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(degrees = 0f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash(degrees = 0f)
}