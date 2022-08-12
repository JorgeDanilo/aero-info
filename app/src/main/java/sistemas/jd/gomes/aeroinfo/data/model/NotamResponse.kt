package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "aisweb", strict = false)
class NotamResponse @JvmOverloads constructor(
    @field:Element(name = "notam")
    var notam: Notam? = null
)