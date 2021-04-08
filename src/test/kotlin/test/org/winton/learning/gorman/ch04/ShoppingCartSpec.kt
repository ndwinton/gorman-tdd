package test.org.winton.learning.gorman.ch04

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch04.Cart
import uk.org.winton.learning.gorman.ch04.LineItem
import java.math.BigDecimal

private val Double.bd: BigDecimal
    get() = BigDecimal(toString())

class ShoppingCartSpec : FunSpec({

    test("Net price for an empty cart is zero") {
        val cart = Cart(emptyList())
        cart.price.shouldBe(BigDecimal.ZERO)
    }

    test("Price for a single line item < 100.0 should be the price of the item") {
        val cart = Cart(listOf(LineItem(42.0.bd, 1)))
        cart.price.shouldBe(42.0.bd)
    }
})