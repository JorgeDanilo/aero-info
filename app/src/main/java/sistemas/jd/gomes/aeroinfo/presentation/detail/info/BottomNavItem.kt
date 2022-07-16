package sistemas.jd.gomes.aeroinfo.presentation.detail.info

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalAirport
import androidx.compose.material.icons.filled.PermDeviceInformation
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var screeRoute: String,
) {
    object INFO_WEATHER :
        BottomNavItem(
            "Inf. Metereologicas",
            Icons.Default.AirplaneTicket,
            "info_met/"
        )

    object INFO_GENERAL :
        BottomNavItem(
            "Inf. Gerais",
            Icons.Default.Info,
            "info_general"
        )

    object INFO_CHARTS :
        BottomNavItem(
            "Cartas de Voo",
            Icons.Default.LocalAirport,
            "info_charts"
        )

    object INFO_ROTAER :
        BottomNavItem(
            "Rotaer",
            Icons.Default.PermDeviceInformation,
            "info_rotaer"
        )
}
