package test.org.winton.learning.gorman.ch04

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch04.isPrime

class PrimeListerSpec : FunSpec({

    test("1 is not prime") {
        1.isPrime().shouldBe(false)
    }

    test("2 is the first prime") {
        2.isPrime().shouldBe(true)
    }
})
