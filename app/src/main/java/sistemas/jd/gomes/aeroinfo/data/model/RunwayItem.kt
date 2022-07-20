package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "runway", strict = false)
class RunwayItem @JvmOverloads constructor(
    @field:Element(name = "ident", required = false)
    var identification: String = "",

    @field:Element(name = "type", required = false)
    var type: String = ""
)
