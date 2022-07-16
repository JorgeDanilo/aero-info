package sistemas.jd.gomes.aeroinfo.presentation.detail.info

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts.InfoCharts
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.InfoGeneral
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.Screen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer.InfoRotaer
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeather
import sistemas.jd.gomes.aeroinfo.presentation.search.SearchAirportScreen
import sistemas.jd.gomes.aeroinfo.presentation.splash.SplashScreen
import sistemas.jd.gomes.aeroinfo.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun NavigationGraph(navController: NavHostController) {
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
            DetailScreen()
        }

        composable(BottomNavItem.INFO_WEATHER.screeRoute) {
            InfoWeather(navController)
        }

        composable(BottomNavItem.INFO_GENERAL.screeRoute) {
            InfoGeneral()
        }

        composable(BottomNavItem.INFO_CHARTS.screeRoute) {
            InfoCharts()
        }

        composable(BottomNavItem.INFO_ROTAER.screeRoute) {
            InfoRotaer()
        }
    }
}