package test.org.winton.learning.gorman.ch04

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch04.toRoman

class RomanNumeralsSpec : FunSpec({

    test("Simplest single-digit cases") {
        table(
            headers("number", "result"),
            row(1, "i"),
            row(2, "ii"),
            row(3, "iii")
        ).forAll { number, result -> number.toRoman().shouldBe(result) }
    }

    test("4 is iv") {
        4.toRoman().shouldBe("iv")
    }

    test("5 is v") {
        5.toRoman().shouldBe("v")
    }

    test("6, 7, 8") {
        table(
            headers("number", "result"),
            row(6, "vi"),
            row(7, "vii"),
            row(8, "viii")
        ).forAll { number, result -> number.toRoman().shouldBe(result) }
    }

    test("9 is ix") {
        9.toRoman().shouldBe("ix")
    }

    test("10, 11, 12, 13") {
        table(
            headers("number", "result"),
            row(10, "x"),
            row(11, "xi"),
            row(12, "xii"),
            row(13, "xiii")
        ).forAll { number, result -> number.toRoman().shouldBe(result) }
    }

    test("14 is xiv") {
        14.toRoman().shouldBe("xiv")
    }
})
