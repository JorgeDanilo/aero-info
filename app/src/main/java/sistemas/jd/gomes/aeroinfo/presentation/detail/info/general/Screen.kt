package sistemas.jd.gomes.aeroinfo.presentation.detail.info.general

import sistemas.jd.gomes.aeroinfo.util.SearchDTO

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Search : Screen("search")
    object Details : Screen("details_screen/{icaoCode}") {
        fun passIcaoCode(icaoCode: String): String {
            SearchDTO.icaoCode = icaoCode
            return "details_screen/$icaoCode"
        }
    }
}
