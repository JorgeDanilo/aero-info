package sistemas.jd.gomes.aeroinfo.presentation.extensions

private const val PRESSURE = "Q"
private const val KT = "KT"

fun String.getPressure(): String {
    return if (this.contains(PRESSURE)) {
        this.let {
            return this.subSequence(matchDetails(this.replace("\n", ""), PRESSURE), this.length - 1)
                .toString()
        }
    } else {
        ""
    }
}

fun String.getWindDirection(): String {
    return if (this.contains(KT)) {
        return if (this.subSequence(0, 3).contains("º")) {
            this.subSequence(0, 2).toString()
        } else {
            this.subSequence(0, 3).toString()
        }
    } else {
        ""
    }
}

fun String.getRunwayDirection(): String {
    this.let {
        return this.subSequence(0, 2).toString() + "0"
    }
}


private fun matchDetails(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
    return inputString.indexOf(whatToFind, startIndex, ignoreCase = true)
}