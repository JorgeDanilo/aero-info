package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "notam", strict = false)
class Notam @JvmOverloads constructor(
    @field:ElementList(
        name = "item",
        inline = true
    ) var notamItem: MutableList<NotaItem> ?= mutableListOf()
)
