package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "cartas", strict = false)
class Chart @JvmOverloads constructor(
    @field:ElementList(
        name = "item",
        inline = true,
    ) var itemChart: MutableList<ItemChart>? = mutableListOf()
)