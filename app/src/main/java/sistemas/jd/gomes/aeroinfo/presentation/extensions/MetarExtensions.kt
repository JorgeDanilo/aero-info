package sistemas.jd.gomes.aeroinfo.presentation.extensions

private const val PRESSURE = "Q"
private const val WIND = "KT"

fun String.getPressure(): CharSequence {
    this.let {
        return this.subSequence(matchDetails(this.replace("\n", ""), PRESSURE), this.length - 1)
    }
}

fun String.getWindDirection(): String {
    this.let {
        return this.subSequence(
            matchDetails(this.replace("\n", ""), WIND) - 5,
            matchDetails(this, WIND) - 2
        ).toString()
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


private fun matchDetails(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
    return inputString.indexOf(whatToFind, startIndex, ignoreCase = true)
}