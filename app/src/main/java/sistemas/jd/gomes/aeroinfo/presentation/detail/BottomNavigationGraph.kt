package sistemas.jd.gomes.aeroinfo.presentation.detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.BottomNavItem
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts.InfoCharts
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.InfoGeneral
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer.InfoRotaer
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeather
import sistemas.jd.gomes.aeroinfo.util.Constants

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.INFO_WEATHER.screeRoute) {
        composable(
            BottomNavItem.INFO_WEATHER.screeRoute,
            arguments = listOf(navArgument(Constants.DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) {
            InfoWeather(navController = navController)
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