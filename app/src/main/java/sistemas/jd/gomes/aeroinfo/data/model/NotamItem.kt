package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item")
class NotamItem @JvmOverloads constructor(

    @field:Element(name = "cat", required = false)
    var category: String = "",

    @field:Element(name = "n", required = false)
    var number: String = "",

    @field:Element(name = "dt", required = false)
    var datePublished: String = "",

    @field:Element(name = "b", required = false)
    var startDateEffective: String = "",

    @field:Element(name = "c", required = false)
    var endDateEffective: String = "",

    @field:Element(name = "e", required = false)
    var informationNotam: String = "",

    @field:Element(name = "d", required = false)
    var activePeriod: String = ""
)
