package sistemas.jd.gomes.aeroinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.DetailScreen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeather
import sistemas.jd.gomes.aeroinfo.presentation.list.ListAirport
import sistemas.jd.gomes.aeroinfo.ui.theme.AeroinfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroinfoTheme {
                DetailScreen()
            }
        }
    }
}