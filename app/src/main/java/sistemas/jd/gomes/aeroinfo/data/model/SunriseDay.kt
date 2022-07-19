package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.util.*

@Root(name = "day")
open class SunriseDay @JvmOverloads constructor(
    @field: Element(name = "date", required = false)
    var dateSunrise: String = "",

    @field: Element(name = "sunrise", required = false)
    var sunrise: String = "",

    @field: Element(name = "sunset", required = false)
    var sunset: String = ""
)