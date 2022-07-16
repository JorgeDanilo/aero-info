package sistemas.jd.gomes.aeroinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.aeroinfo.presentation.search.ListAirport
import sistemas.jd.gomes.aeroinfo.ui.theme.AeroinfoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroinfoTheme {
                ListAirport()
            }
        }
    }
}