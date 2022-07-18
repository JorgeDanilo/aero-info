package sistemas.jd.gomes.aeroinfo.data.model

import org.simpleframework.xml.Element

enum class TypeCharts {
    @Element(name = "STAR")
    STAR,

    @Element(name = "VAC")
    VAC,

    @Element(name = "ADC")
    ADC,

    @Element(name = "IAC")
    IAC,

    @Element(name = "SID")
    SID
}