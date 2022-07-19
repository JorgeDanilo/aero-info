package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item")
class ItemChart @JvmOverloads constructor(

    @field:Element(name = "id", required = false)
    var id: String = "",

    @field:Element(name = "tipo", required = false)
    var type: TypeCharts? = null,

    @field:Element(name = "tipo_descr", required = false)
    var description: String = "",

    @field:Element(name = "nome", required = false)
    var nome: String = "",

    @field:Element(name = "link", required = false)
    var link: String = "",

    @field:Element(name = "arquivo", required = false)
    var arquivo: String = ""
)