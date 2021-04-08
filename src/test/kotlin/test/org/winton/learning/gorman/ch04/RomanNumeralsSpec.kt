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

    test("19, 20, 21 -> x as a leading element") {
        table(
            headers("number", "result"),
            row(19, "xix"),
            row(20, "xx"),
            row(21, "xxi"),
        ).forAll { number, result -> number.toRoman().shouldBe(result) }
    }

    test("44 -> xliv - requires the introduction of l") {
        44.toRoman().shouldBe("xliv")
    }

    test("88 -> lxxxviii - l as a leading element") {
        88.toRoman().shouldBe("lxxxviii")
    }

    test("99 -> xcix - introduces c") {
        99.toRoman().shouldBe("xcix")
    }

    test("388 -> ccclxxxviii - c as a units digit") {
        388.toRoman().shouldBe("ccclxxxviii")
    }

    test("499 -> cdxcix - introduces d") {
        499.toRoman().shouldBe("cdxcix")
    }

    test("900 -> cm - introduces m") {
        900.toRoman().shouldBe("cm")
    }

    test("3999 -> mmmcmxcix - limit of problem") {
        3999.toRoman().shouldBe("mmmcmxcix")
    }
})
