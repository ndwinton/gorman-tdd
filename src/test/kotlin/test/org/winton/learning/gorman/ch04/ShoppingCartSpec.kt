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

    test("Price for multiple line items < 100.0 should be the sum of the item prices") {
        val cart = Cart(listOf(LineItem(42.0.bd, 1), LineItem(21.0.bd, 1)))
        cart.price.shouldBe(63.0.bd)
    }

    test("Total price < 100.0 should take account of item quantities") {
        val cart = Cart(listOf(LineItem(1.0.bd, 3), LineItem(2.0.bd, 5)))
        cart.price.shouldBe(13.0.bd)
    }

    test("Total price > 100 and < 200 attract 5% discount") {
        val cart = Cart(listOf(LineItem(50.0.bd, 3)))
        cart.price.shouldBe(142.5.bd)
    }
})