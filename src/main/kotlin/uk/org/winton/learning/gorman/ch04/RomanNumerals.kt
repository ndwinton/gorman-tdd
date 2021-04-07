package uk.org.winton.learning.gorman.ch04

fun Int.toRoman(): String {
    val (prefix, suffix) = if (this == 4) Pair("i", "") else Pair("", "i".repeat(this % 5))
    val middle = if (this > 3) "v" else ""
    return prefix + middle + suffix
}