package sistemas.jd.gomes.aeroinfo.presentation.detail.info

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.charts.InfoCharts
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.general.InfoGeneral
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer.InfoRotaer
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.weather.InfoWeather

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.INFO_WEATHER.screeRoute) {
        composable(BottomNavItem.INFO_WEATHER.screeRoute) {
            InfoWeather()
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