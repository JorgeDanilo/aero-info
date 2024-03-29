package sistemas.jd.gomes.aeroinfo.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.aeroinfo.presentation.NavGraph
import sistemas.jd.gomes.aeroinfo.ui.theme.AeroinfoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroinfoTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}