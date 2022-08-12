package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "aisweb", strict = false)
class SunriseDayResponse @JvmOverloads constructor(
    @field:ElementList(
        name = "day",
        inline = true,
    ) var sunriseDays: MutableList<SunriseDay>? = mutableListOf()
)