package sistemas.jd.gomes.aeroinfo.presentation.detail.info.general

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Search : Screen("search")
    object Details : Screen("details_screen/{icaoCode}") {
        fun passIcaoCode(icaoCode: String): String {
            return "details_screen/$icaoCode"
        }
    }
}
