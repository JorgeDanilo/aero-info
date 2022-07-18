package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item")
class ItemChart @JvmOverloads constructor(
    @field:Element(name = "tipo")
    var type: TypeCharts? = null,

    @field:Element(name = "tipo_descr")
    var description: String = "",

    @field:Element(name = "nome")
    var nome: String = "",

    @field:Element(name = "link")
    var link: String = ""
)