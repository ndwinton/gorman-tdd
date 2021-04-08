package uk.org.winton.learning.gorman.ch04

fun Int.toRoman(): String {
    val thousands = (this / 1000).romanUnits("m", "?", "?")
    val hundreds = (this / 100).romanUnits("c", "d", "m")
    val tens = (this / 10).romanUnits("x", "l", "c")
    return thousands + hundreds + tens + (this % 10).romanUnits("i", "v", "x")
}

private fun Int.romanUnits(onesLetter: String, fivesLetter: String, tensLetter: String): String {
    val units = this % 10
    val (prefix, suffix) = if (units % 5 == 4) Pair(onesLetter, "") else Pair("", onesLetter.repeat(units % 5))
    val middle = when {
        units == 9 -> tensLetter
        units >= 4 -> fivesLetter
        else -> ""
    }
    return prefix + middle + suffix
}