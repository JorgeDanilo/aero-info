package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "aisweb", strict = false)
class RotaerResponse @JvmOverloads constructor(
    @field:Element(
        name = "runways",
    ) var runways: Runway? = null,
)