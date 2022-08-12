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
    SID,

    @Element(name = "AOC")
    AOC,

    @Element(name = "PDC")
    PDC,

    @Element(name = "GMC")
    GMC,

    @Element(name = "PATC")
    PATC


}