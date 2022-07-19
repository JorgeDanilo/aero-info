package sistemas.jd.gomes.aeroinfo.presentation.detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.BottomNavItem
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts.InfoChartsScreen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.InfoGeneralScreen
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer.InfoRotaer
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeatherScreen

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.INFO_WEATHER.screeRoute) {
        composable(BottomNavItem.INFO_WEATHER.screeRoute) {
            InfoWeatherScreen()
        }

        composable(BottomNavItem.INFO_GENERAL.screeRoute) {
            InfoGeneralScreen()
        }

        composable(BottomNavItem.INFO_CHARTS.screeRoute) {
            InfoChartsScreen()
        }

        composable(BottomNavItem.INFO_ROTAER.screeRoute) {
            InfoRotaer()
        }
    }
}