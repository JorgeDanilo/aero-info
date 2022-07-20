package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "runways", strict = false)
class Runway @JvmOverloads constructor(
    @field:ElementList(
        name = "runway",
        inline = true
    ) var runwayItem: MutableList<RunwayItem>? = mutableListOf()
)
