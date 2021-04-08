package uk.org.winton.learning.gorman.ch04

import java.math.BigDecimal

class Cart(private val lineItems: List<LineItem>) {

    val price: BigDecimal get() = lineItems.sumOf { it.price }
}

data class LineItem(val price: BigDecimal, val quantity: Int)
