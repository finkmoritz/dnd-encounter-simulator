package io.github.finkmoritz.dndencountersimulator.dice

class Dice(private val expression: String) {

    fun roll(): UInt {
        val (product, modifier) = expression.split("+").map { it.trim() }
        val (numDice, numSides) = product.split("d").map { it.trim().toInt() }
        return ((1..numDice).sumOf { (1..numSides).random() } + modifier.toInt()).toUInt()
    }
}