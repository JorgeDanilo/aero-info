package sistemas.jd.gomes.aeroinfo.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import sistemas.jd.gomes.aeroinfo.presentation.detail.DetailScreen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.Screen
import sistemas.jd.gomes.aeroinfo.presentation.search.SearchAirportScreen
import sistemas.jd.gomes.aeroinfo.presentation.splash.SplashScreen
import sistemas.jd.gomes.aeroinfo.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Search.route) {
            SearchAirportScreen(navController = navController)
        }

        composable(Screen.Details.route, arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
            type = NavType.StringType
        })) {
            DetailScreen(navController = navController)
        }
    }
}