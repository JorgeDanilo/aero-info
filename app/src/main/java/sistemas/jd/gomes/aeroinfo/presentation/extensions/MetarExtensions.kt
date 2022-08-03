package sistemas.jd.gomes.aeroinfo.presentation.extensions

private const val PRESSURE = "Q"
private const val WIND = "KT"

fun String.getPressure(): String {
    return if (this.contentEquals(PRESSURE)) {
        this.let {
            return this.subSequence(matchDetails(this.replace("\n", ""), PRESSURE), this.length - 1)
                .toString()
        }
    } else {
        ""
    }
}

fun String.getWindDirection(): String {
    return if (this.contentEquals(WIND)) {
        this.let {
            return this.subSequence(
                matchDetails(this.replace("\n", ""), WIND) - 5,
                matchDetails(this, WIND) - 2
            ).toString()
        }
    } else {
        ""
    }

}

fun String.getWindSpeed(): String {
    this.let {
        return this.subSequence(
            matchDetails(this.replace("\n", ""), WIND) - 2,
            matchDetails(this, WIND)
        ).toString()
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