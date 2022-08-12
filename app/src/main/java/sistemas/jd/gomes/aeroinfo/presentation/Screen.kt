package sistemas.jd.gomes.aeroinfo.presentation

import sistemas.jd.gomes.aeroinfo.util.SearchDTO

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Search : Screen("search")
    object Sigwx: Screen("sigwx_screen/{url}") {
        fun passUrl(url: String) : String {
            SearchDTO.urlChartSigwx = url
            return "sigwx_screen/$url"
        }
    }
    object Details : Screen("details_screen/{icaoCode}") {
        fun passIcaoCode(icaoCode: String): String {
            SearchDTO.icaoCode = icaoCode
            return "details_screen/$icaoCode"
        }
    }
}
