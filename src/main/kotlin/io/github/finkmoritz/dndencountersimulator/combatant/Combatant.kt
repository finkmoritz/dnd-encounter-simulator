package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

interface Combatant {

    fun name(): String

    fun hp(): UInt

    fun ac(): UInt

    fun rollInitiative(): UInt

    fun rollAttack(): UInt

    fun rollDamage(): UInt

    fun takeDamage(amount: UInt)

    fun targetingStrategy(): TargetingStrategy

    fun isAlive(): Boolean {
        return hp() > 0u
    }

    fun isDead(): Boolean {
        return !isAlive()
    }
}