package uk.org.winton.learning.gorman.ch04

import java.math.BigDecimal

class Cart(private val lineItems: List<LineItem>) {

    val price: BigDecimal get() {
        val gross = lineItems.sumOf { it.price * it.quantity.toBigDecimal() }
        return when {
            gross > discount2Threshold -> (gross * discount2Factor).stripTrailingZeros()
            gross > discount1Threshold -> (gross * discount1Factor).stripTrailingZeros()
            else -> gross
        }
    }

    companion object {
        val discount1Threshold = "100.0".toBigDecimal()
        val discount1Factor = "0.95".toBigDecimal()
        val discount2Threshold = "200.0".toBigDecimal()
        val discount2Factor = "0.90".toBigDecimal()
    }
}

data class LineItem(val price: BigDecimal, val quantity: Int)
