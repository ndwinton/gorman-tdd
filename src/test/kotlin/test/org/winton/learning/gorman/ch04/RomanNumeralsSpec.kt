package test.org.winton.learning.gorman.ch04

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch04.toRoman

class RomanNumeralsSpec : FunSpec({
    test("1 is i") {
        1.toRoman().shouldBe("i")
    }
})
