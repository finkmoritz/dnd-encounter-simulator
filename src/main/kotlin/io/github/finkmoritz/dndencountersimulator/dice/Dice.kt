package io.github.finkmoritz.dndencountersimulator.dice

import kotlin.math.max

class Dice(
    private val multiplier: UInt,
    private val sides: UInt,
    private val modifier: Int = 0,
) {

    fun roll(): UInt {
        val roll = (1..multiplier.toInt()).sumOf { (1..sides.toInt()).random() } + modifier
        return max(1, roll).toUInt()
    }

    companion object {
        fun D4() = Dice(1u, 4u)
        fun D6() = Dice(1u, 6u)
        fun D8() = Dice(1u, 8u)
        fun D10() = Dice(1u, 10u)
        fun D12() = Dice(1u, 12u)
        fun D20() = Dice(1u, 20u)

        fun fromExpression(expression: String): Dice {
            val (product, modifier) = expression.split("+").map { it.trim() }
            val (multiplier, sides) = product.split("d").map { it.trim().toUInt() }

            return Dice(multiplier, sides, modifier.toIntOrNull() ?: 0)
        }
    }
}