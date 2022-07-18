package sistemas.jd.gomes.aeroinfo.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val BlueGrey900 = Color(0xFF263238)
val Grey100 = Color(0xFFF5F5F5)

val Color2 = Color(0xFF7890A8)
val Color3 = Color(0XFF304878)
val Color4 = Color(0XFF181848)
val Color5 = Color(0XFFF0A818)
val Color6 = Color(0XFF90ff17)
val colorBackground = Color(0XFF0057A3)

val Colors.GrayPrimary
    get() = Color2

val Colors.GrayDark
    get() = Color3

val Colors.BlueDark
    get() = Color4

val Colors.YellowDark
    get() = Color5

val Colors.GreenDark
    get() = Color6

val Colors.AppThemColor
    get() = if (isLight) Color.White else Color.Black

val Colors.AppContentColor
    get() = if (isLight) Color.Black else Color.White

val Colors.TitleColor
    get() = if (isLight) Color.Black else Color.White

val Colors.ItemBackgroundColor
    get() = if (isLight) Grey100 else BlueGrey900

val Colors.Background
get() = colorBackground