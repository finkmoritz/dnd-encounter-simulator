package io.github.finkmoritz.dndencountersimulator.damage

data class Damage(
    val amount: UInt,
    val type: DamageType,
    val extraAmount: UInt? = null,
    val extraType: DamageType? = null,
)