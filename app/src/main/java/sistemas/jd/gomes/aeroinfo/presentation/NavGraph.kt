package sistemas.jd.gomes.aeroinfo.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sistemas.jd.gomes.aeroinfo.presentation.detail.DetailScreen
import sistemas.jd.gomes.aeroinfo.presentation.search.SearchAirportScreen
import sistemas.jd.gomes.aeroinfo.presentation.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Search.route) {
            SearchAirportScreen(navController = navController)
        }

        composable(Screen.Details.route) {
            DetailScreen()
        }
    }
}