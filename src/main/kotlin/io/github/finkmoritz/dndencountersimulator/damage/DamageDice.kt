package io.github.finkmoritz.dndencountersimulator.damage

import io.github.finkmoritz.dndencountersimulator.dice.Dice

class DamageDice(
    private val amount: Dice,
    private val type: DamageType,
    private val extraAmount: Dice? = null,
    private val extraType: DamageType? = null,
) {

    fun roll(): Damage {
        return Damage(
            amount.roll(),
            type,
            extraAmount?.roll(),
            extraType,
        )
    }

    companion object {
        fun fromExpressions(
            amountExpression: String,
            type: DamageType,
            extraAmountExpression: String? = null,
            extraType: DamageType? = null,
        ): DamageDice {
            val amount = Dice.fromExpression(amountExpression)
            val extraAmount = extraAmountExpression?.let { Dice.fromExpression(it) }

            return DamageDice(amount, type, extraAmount, extraType)
        }
    }
}