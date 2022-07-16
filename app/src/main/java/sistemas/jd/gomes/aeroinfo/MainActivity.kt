package sistemas.jd.gomes.aeroinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.NavigationGraph
import sistemas.jd.gomes.aeroinfo.ui.theme.AeroinfoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroinfoTheme {
                navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}