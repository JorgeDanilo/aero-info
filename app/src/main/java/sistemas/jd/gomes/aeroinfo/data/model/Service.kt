package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "service", strict = false)
class Service @JvmOverloads constructor(
    @field:Element(
        name = "freqs",
        required = false
    ) var freqs: Frequency ? = null
)
