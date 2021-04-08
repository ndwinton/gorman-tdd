package uk.org.winton.learning.gorman.ch04

fun Int.toRoman(): String {
    val tens = "x".repeat(this / 10)
    return tens + (this % 10).romanUnits()
}

private fun Int.romanUnits(): String {
    val (prefix, suffix) = if (this % 5 == 4) Pair("i", "") else Pair("", "i".repeat(this % 5))
    val middle = when {
        this > 8 -> "x"
        this > 3 -> "v"
        else -> ""
    }
    return prefix + middle + suffix
}