package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "met", strict = false)
class Meteorology @JvmOverloads constructor(
    @field: Element(name = "loc")
    var loc: String = "",
    @field: Element(name = "metar", required = false)
    var metar: String = "",
    @field: Element(name = "taf", required = false)
    var taf: String? = ""
)