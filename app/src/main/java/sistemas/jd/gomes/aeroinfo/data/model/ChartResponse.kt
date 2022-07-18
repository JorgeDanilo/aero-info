package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "aisweb", strict = false)
class ChartResponse @JvmOverloads constructor(
    @field:Element(name = "cartas")
    var charts: Chart? = null
)