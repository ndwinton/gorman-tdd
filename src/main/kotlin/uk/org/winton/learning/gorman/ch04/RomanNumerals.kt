package uk.org.winton.learning.gorman.ch04

fun Int.toRoman(): String {
    val tens = (this / 10).romanUnits("x", "l", "c")
    return tens + (this % 10).romanUnits("i", "v", "x")
}

private fun Int.romanUnits(onesLetter: String, fivesLetter: String, tensLetter: String): String {
    val (prefix, suffix) = if (this % 5 == 4) Pair(onesLetter, "") else Pair("", onesLetter.repeat(this % 5))
    val middle = when {
        this > 8 -> tensLetter
        this > 3 -> fivesLetter
        else -> ""
    }
    return prefix + middle + suffix
}