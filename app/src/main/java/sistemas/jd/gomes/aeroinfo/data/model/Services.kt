package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "services", strict = false)
class Services @JvmOverloads constructor(
    @field:ElementList(
        name = "service",
        inline = true,
        required = false
    ) var services: MutableList<Service> = mutableListOf()
)
