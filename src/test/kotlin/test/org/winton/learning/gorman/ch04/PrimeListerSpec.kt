package test.org.winton.learning.gorman.ch04

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch04.isPrime
import uk.org.winton.learning.gorman.ch04.isRelativelyPrimeTo
import uk.org.winton.learning.gorman.ch04.primesBelow

class PrimeListerSpec : FunSpec({

    test("1 is not prime") {
        1.isPrime().shouldBe(false)
    }

    test("2 is the first prime") {
        2.isPrime().shouldBe(true)
    }

    test("number not divisible by any number in given list is relatively prime") {
        table(
            headers("number", "divisors", "result"),
            row(3, listOf(2), true),
            row(3, listOf(3), false),
            row(8, listOf(4), false),
            row(7, listOf(2, 3), true),
            row(8, listOf(5, 2), false),
        ).forAll { number, divisors, result ->
            number.isRelativelyPrimeTo(divisors).shouldBe(result)
        }
    }

    test("all numbers are relatively prime to 1") {
        table(
            headers("number", "divisors", "result"),
            row(2, listOf(1), true),
            row(3, listOf(1), true),
            row(99, listOf(1), true),
            row(357, listOf(1), true),
        ).forAll { number, divisors, result ->
            number.isRelativelyPrimeTo(divisors).shouldBe(result)
        }
    }

    test("number is prime if relatively prime to all numbers below it") {
        table(
            headers("number", "result"),
            row(2, true),
            row(3, true),
            row(4, false),
            row(47, true),
            row(51, false),
            row(99, false),
            row(101, true),
        ).forAll { number, result ->
            number.isRelativelyPrimeTo((1 .. number - 1).toList()).shouldBe(result)
            number.isPrime().shouldBe(result)
        }
    }

    test("listing primes below 1") {
        primesBelow(1).shouldBeEmpty()
    }

    test("listing primes below 2") {
        primesBelow(2).shouldBeEmpty()
    }

    test("listing primes below limits") {
        table(
            headers("number", "result"),
            row(3, listOf(2)),
            row(4, listOf(2, 3)),
            row(10, listOf(2, 3, 5, 7)),
            row(20, listOf(2, 3, 5, 7, 11, 13, 17, 19)),
        ).forAll { number, result ->
            primesBelow(number).shouldBe(result)
        }
    }

    test("listing all primes below 1000") {
        val list = primesBelow(1000)
        list.size.shouldBe(168)
        list.last().shouldBe(997)
        list[69].shouldBe(349)
    }
})

