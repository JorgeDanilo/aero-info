package sistemas.jd.gomes.aeroinfo.util

import java.util.*

open class TimeMachine {

    open fun today() = now()
    open fun now() = Date()

}