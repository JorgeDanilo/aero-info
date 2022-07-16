package sistemas.jd.gomes.aeroinfo.presentation.detail

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import sistemas.jd.gomes.aeroinfo.presentation.detail.info.BottomNavItem
import sistemas.jd.gomes.aeroinfo.ui.theme.GrayDark
import sistemas.jd.gomes.aeroinfo.ui.theme.YellowDark

@Composable
fun DetailScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        BottomNavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.INFO_WEATHER,
        BottomNavItem.INFO_GENERAL,
        BottomNavItem.INFO_CHARTS,
        BottomNavItem.INFO_ROTAER
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.GrayDark,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title, fontSize = 9.sp)
                },
                selectedContentColor = MaterialTheme.colors.YellowDark,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screeRoute,
                onClick = {
                    navController.navigate(item.screeRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}