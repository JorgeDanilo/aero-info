package sistemas.jd.gomes.aeroinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.DetailScreen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.TextFieldWithDropDown
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeather
import sistemas.jd.gomes.aeroinfo.presentation.list.ListAirport
import sistemas.jd.gomes.aeroinfo.ui.theme.AeroinfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroinfoTheme {
                Column {
                    TextFieldWithDropDown(
                        items = listOf("sbgo", "sbnv", "sbsp", "sbpa"),
                        selectedValue = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) { index ->
                        println("$index was selected")
                    }
                }
            }
        }
    }
}