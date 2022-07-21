package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementArray
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "freqs", strict = false)
class Frequency @JvmOverloads constructor(
   @field:Element(
       name = "freq",
       required = false,
   ) var itemsFreq: FrequencyItem ?= null
)
