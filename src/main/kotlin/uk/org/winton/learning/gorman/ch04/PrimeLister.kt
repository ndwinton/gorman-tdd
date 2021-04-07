package uk.org.winton.learning.gorman.ch04

fun Int.isPrime(): Boolean {
    return this > 1 && isRelativelyPrimeTo((1 until this).toList())
}

fun Int.isRelativelyPrimeTo(divisors: List<Int>): Boolean {
    return divisors.all { it == 1 || this % it != 0 }
}

fun primesBelow(limit: Int): List<Int> = (1 until limit).filter { it.isPrime() }