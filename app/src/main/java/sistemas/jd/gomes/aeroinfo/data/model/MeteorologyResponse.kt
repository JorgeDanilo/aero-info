package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "aisweb", strict = false)
class MeteorologyResponse @JvmOverloads constructor(
    @field: Element(name = "met") var meteoroly: Meteorology? = null
)